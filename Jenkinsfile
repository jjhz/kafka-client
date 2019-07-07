pipeline {
    agent any

    tools {
            maven '3.3.9'
            jdk 'jdk8'
    }

    stages {

        stage('maven'){
            steps {
                sh '''
                    mvn clean install
                '''
            }
            post {
                     success {
                           junit 'target/surefire-reports/**/*.xml'
                     }
            }

        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}