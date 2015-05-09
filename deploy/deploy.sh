#!/bin/bash

# 项目启动脚本

#!/bin/bash
# 3parms, fullpack

APP_NAME="fantuan"
APP_PROFILES="test production"

function __help(){
    echo "usage: $0 <commond> <profile> <port> <print:ture|false> <buildTag>"
    exit
}

if [[ $# < 5 ]]; then
    __help
fi

CP=cp
RM=rm
JAVA=java
MVN=mvn
SUPERVISORCTL=supervisorctl

ROOT_DIR=/opt/fantuan
APPS_ROOT=${ROOT_DIR}/apps
LOGS_ROOT=${ROOT_DIR}/logs

DEPLOY_SCRIPT=$0

COMMOND=$1

APP_PROFILE=$2
APP_PORT=$3

PRINT_STDOUT=$4

BUILD_TAG=$5

APP=${APP_NAME}-${APP_PROFILE}-${APP_PORT}

LOG_DIR=${LOGS_ROOT}/${APP}
APP_DIR=${APPS_ROOT}/${APP}

BASE_NAME=$(basename ${DEPLOY_SCRIPT})
DEPLOY_DIR=$(dirname ${DEPLOY_SCRIPT})
JAR=${APP_NAME}.jar
TARGET_JAR=${DEPLOY_DIR}/../fantuan-server/target/${JAR}

NEW_DEPLOY_SCIRPT=${APP_DIR}/${BASE_NAME}
NEW_CONF=${APP_DIR}/supervisor.conf
NEW_JAR=${APP_DIR}/${JAR}

function __checkProfile(){
   for PROFILE_OPTION in ${APP_PROFILES}
   do
      if [ "${PROFILE_OPTION}" == "${APP_PROFILE}" ]; then
         return
      fi
   done
   echo "No profile found with: ${APP_PROFILE} in ${APP_PROFILES}"
   __help
}

__checkProfile


function __install(){
    if [ ! -d "${LOG_DIR}" ];then
        echo "make LOG_DIR at ${LOG_DIR}"
        mkdir -p ${LOG_DIR}
    fi

    if [ -d "${APP_DIR}" ];then
        ${RM} -rf ${APP_DIR}
    fi

    echo "make APP_DIR at ${APP_DIR}"
    mkdir -p ${APP_DIR}
    ${CP} -r ${DEPLOY_DIR}/* ${APP_DIR}/
    ${CP} ${TARGET_JAR} ${NEW_JAR}
    chmod +x ${NEW_DEPLOY_SCIRPT}

    echo "[program:${APP}]" > ${NEW_CONF}
    echo "command=bash $NEW_DEPLOY_SCIRPT run ${APP_PROFILE} ${APP_PORT} ${PRINT_STDOUT} ${BUILD_TAG}" >> ${NEW_CONF}
}

function __start(){
    echo 'beigin __start()!'
    echo 'update supervisor process'
    ${SUPERVISORCTL} update
    ${SUPERVISORCTL} start ${APP}

    k=1
    for k in $(seq 1 20)
    do
        sleep 1
        PID=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | awk '{print $2}'`
        if [ "${PID}" != "" ]; then
            break
        fi
        echo ${k}
        if [ ${k} -eq 20 ]
        then
            echo 'process start time more than 20s, so abort'
            exit -1
        fi
    done
    sleep 15
    PID=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | awk '{print $2}'`
    if [ "${PID}" == "" ]; then
        echo 'cannot found process '
        exit -1
    fi
    num=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | wc -l`
    if [ ${num} -gt 1 ]; then
        echo "have two ${APP} instances!!!"
        exit -1
    fi
    echo 'start successfully !!!'
}

function __stop(){
    echo 'beigin __stop()!'
    echo "stop supervisor process: ${APP}"
    ${SUPERVISORCTL} stop ${APP}
    PID=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | awk '{print $2}'`
    if [ "${PID}" != "" ]; then
    	kill ${PID}
    	sleep 1
    fi
    PID=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | awk '{print $2}'`
    if [ "${PID}" != "" ]; then
        sleep 3
        PID=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | awk '{print $2}'`
        if [ "${PID}" != "" ]; then
            sleep 8
            PID=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | awk '{print $2}'`
            if [ "${PID}" != "" ]; then
                sleep 30
                PID=`ps -ef | grep " -Dapp.name=${APP} " | grep -v grep | awk '{print $2}'`
                if [ "${PID}" != "" ]; then
                    echo 'cannot shutdown normally, so use kill -9'
                    kill -9 ${PID}
                fi
            fi
        fi
    fi
}


function __run(){
    EXEC="exec"

    cd ${APP_DIR}

    JVM_ARGS=""
    JVM_JIT=""
    JVM_DEBUG=""
    JVM_JMX=""
    JVM_GC=""
    JVM_HEAP=""
    JVM_SIZE=""
    JAVA_ARGS=""


    if [ -e "boot.ini" ]; then
        source boot.ini
    fi

    if [ -e "boot-${APP_PROFILE}.ini" ]; then
        source boot-${APP_PROFILE}.ini
    fi

    EXEC_JAVA="$EXEC $JAVA $JVM_ARGS $JVM_SIZE $JVM_HEAP $JVM_JIT $JVM_GC"
    EXEC_JAVA=${EXEC_JAVA}" -Xloggc:${LOG_DIR}/${APP}.gc.log -XX:ErrorFile=${LOG_DIR}/${APP}.vmerr.log -XX:HeapDumpPath=${LOG_DIR}/${APP}.heaperr.log"

    if [ "$JVM_JMX" != "" ]; then
        JVM_JMX_PORT=`expr ${APP_PORT} '+' 10000`
        EXEC_JAVA=${EXEC_JAVA}" -Dcom.sun.management.jmxremote.port=$JVM_JMX_PORT $JVM_JMX"
    fi

    if [ "$JVM_DEBUG" != "" ]; then
        JVM_DEBUG_PORT=`expr ${APP_PORT} '+' 20000`
        EXEC_JAVA=${EXEC_JAVA}" $JVM_DEBUG,address=$JVM_DEBUG_PORT"
    fi

    EXEC_JAVA=${EXEC_JAVA}" -Dapp.name=${APP} -Dapp.description=${BUILD_TAG} -Djetty.logs=${LOG_DIR}"
    EXEC_JAVA=${EXEC_JAVA}" $JAVA_ARGS "
    EXEC_JAVA=${EXEC_JAVA}" -Dserver.port=${APP_PORT} -Dspring.profiles.active=${APP_PROFILE} -jar ${NEW_JAR}"

    if [ "$UID" = "0" ]; then
        ulimit -n 102400
        umask 000
    else
        echo ${EXEC_JAVA}
    fi

    ${EXEC_JAVA}  2>&1
}

function __deploy(){
    __stop
    __install
    __start
}

function __dispatcher(){
    case ${COMMOND} in
        'install')
            echo "install..."
            __install
            ;;
        'start')
            echo "start..."
            __start
            ;;
        'run')
            __run
            ;;
        'stop')
            echo "stop..."
            __stop
            ;;
        'deploy')
            echo "deploy..."
            __deploy
            ;;
        '*')
            echo "未知命令..."
            exit -1
            ;;
    esac
}

__dispatcher