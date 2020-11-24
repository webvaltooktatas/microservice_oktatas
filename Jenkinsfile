pipeline {
    agent any
    stages {
        stage('test') {
            sh 'gradle clean test'
        }
        stage('build') {
            sh 'gradle clean build -x test'
        }
    }
}