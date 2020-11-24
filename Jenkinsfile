pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                sh 'gradle clean test'
            }
        }
        stage('build') {
            steps {
                sh 'gradle clean build -x test'
            }
        }
    }
}