package exemples

import net.xqj.exist.ExistXQDataSource

fun main() {
    val s = ExistXQDataSource()

    val conn = s.getConnection()
    println("Connexió feta")
    val sent = "for \$alumne in doc(\"/db/Tema9/classe.xml\")//alumne order by \$alumne/cognoms return \$alumne"

    //val cons = conn.prepareExpression (sent)
    //val rs = cons.executeQuery ()

    val cons = conn.createExpression()
    val rs = cons.executeQuery(sent)

    while (rs.next())
        println(rs.getItemAsString(null))
}


