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

    stage('Deploy') {
        sh 'echo Deployando...'
        sh 'echo Deploy Exitoso!'
    }
}