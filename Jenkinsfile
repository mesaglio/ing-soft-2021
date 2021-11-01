node {
    stage('Build') {
        git url: 'https://github.com/mesaglio/ing-soft-2021'
        sh './gradlew init'
        sh './gradlew build'
    }

    stage('Test') {
        sh './gradlew test'
    }
    
    stage('Validate') {
        sh './gradlew check'
    }

    stage('Jacoco Test') {
            sh './gradlew -i test jacocoTestReport'
    }

    stage('Analyze') {
      withSonarQubeEnv() {
        sh "./gradlew sonarqube \
          -Dsonar.host.url=http://sonarqube:9000 \
          -Dsonar.login=admin \
          -Dsonar.password=ingsoft"
      }
    }

    stage('Deploy') {
        sh 'echo Deployando...'
        sh 'echo Deploy Exitoso!'
    }
}