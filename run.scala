val dataDf = spark.read.option("header","true").option("inferSchema","true").csv("data.csv")
dataDf.printSchema
// dataDf.show(1)
dataDf.createOrReplaceTempView("dataview")

// assignment 1
println("Input director Name")
val dir = readLine
println("Input start year")
val start = readLine
println("Input end year")
val end = readLine
spark.sql(s"select title from dataview where director = '${dir}' AND Year(date_published) between ${start} AND ${end}").show()

// assignment 2
println("Input User Review")
val reviewCount = readLine
spark.sql(s"select title,reviews_from_users from dataview where language = 'English' AND reviews_from_users > ${reviewCount} ORDER BY reviews_from_users desc").show()

// assignment 4
println("Input Year")
val country = readLine
spark.sql(s"select title,duration,votes from dataview where country = '${country}' AND votes > avg_vote ORDER BY duration").show()
