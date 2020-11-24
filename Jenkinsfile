pipeline {
    agent {
        docker {
            image 'gradle:6.7-jdk8'
        }
    }
    stages {
        stage('test') {
            steps {
               script {
                   try {
                       sh './gradlew clean test --no-daemon' //run a gradle task
                   } finally {
                       junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                   }
               }
            }
        }
        stage('build') {
            steps {
                script {
                   try {
                       sh './gradlew clean build -x test --no-daemon' //run a gradle task
                   } finally {
                   }
                }
            }
        }
    }
}