#!/usr/bin/env groovy

@Library('ZomisJenkins')
import net.zomis.jenkins.Duga

pipeline {
    agent any

    options {
        timeout(time: 1, unit: 'HOURS')
    }
    tools {
        jdk 'JavaLatest'
    }

    stages {
        stage('Build') {
            options {
                timeout(time: 30, unit: 'MINUTES')
            }
            steps {
                sh './gradlew clean :composeApp:wasmJsBrowserDistribution --info'
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            options {
                timeout(time: 5, unit: 'MINUTES')
            }
            steps {
                sh 'rm -rf /home/zomis/www/getmotivated'
                sh 'cp -r composeApp/build/dist/wasmJs/productionExecutable/* /home/zomis/www/jenkins/getmotivated'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: '**/build/test-results/**/TEST-*.xml'
        }
        success {
            zpost(0)
        }
        unstable {
            zpost(1)
        }
        failure {
            zpost(2)
        }
    }
}
