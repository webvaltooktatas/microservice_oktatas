pipeline {
    agent {
        docker {
            image 'gradle:6.7-jdk8'
        }
    }
    stages {
        stage('test') {
            steps {
                echo 'Test stage'
                gradle clean test
            }
        }
        stage('build') {
            steps {
                echo 'Build stage'
                gradle clean build -x test
            }
        }
    }
}