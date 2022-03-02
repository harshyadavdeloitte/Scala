import java.io.FileNotFoundException
import scala.io.Source

object assignment {
  def main(args: Array[String]): Unit = {
    val filename = "C:\\Users\\harshyadav\\Desktop\\scala\\untitled\\src\\main\\scala\\data.csv"
    val data: List[String] = Source.fromFile(filename).getLines().toList


    println("Milestone 1\n")

    println("Input Director name")//D.W. Griffith
    val director = readLine()
    println("Input year from")
    val fromYear = readLine()
    println("Input year to")
    val toYear = readLine()

    data.foreach(x => {
      val field = x.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)").toList
      val year = field(4).split("-").toList(0)
      if(field(9) == director.toString && year >= fromYear.toString && year <= toYear.toString) println(field(1) + "\t|\t" + field(9) +"\t|\t"+ field(4))
    })

    println("Milestone 2\n")

    println("Input Required User Review")
    val userReview = readLine()
    var res = List[List[String]]()
    data.foreach(x => {
      val field = x.split("(?!\\B\"[^\"]*),(?![^\"]*\"\\B)").toList
      try {
        if (field(8) == "English" && field(20) > userReview.toString) {res = res :+ (List(field(1) ,field(8),field(20))) }
        val sortedRes = res.sortWith((x:List[String],y:List[String]) => x(2).toInt >= y(2).toInt)
        println("Title   , Language,  User Rating" )
        sortedRes.foreach(x=>println(x))
      }
      catch {
        case throwable: Throwable =>
      }
    })

  }
}
