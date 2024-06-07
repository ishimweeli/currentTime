pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'chmod +x ./mvnw'
        sh './mvnw wrapper:wrapper'
      }
    }
    stage('Run Tests') {
      steps {
        sh 'chmod +x ./mvnw'
        sh './mvnw test'
      }
    }
    stage('Clean WS') {
      steps {
        cleanWs()
      }
    }
  }
}