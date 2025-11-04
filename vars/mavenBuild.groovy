def call(String goals = 'clean install') {
    sh """
        mvn ${goals} -DskipTests -B
    """
}
