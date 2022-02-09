package exemples

import net.xqj.exist.ExistXQDataSource
import javax.xml.xquery.XQResultItem

fun main() {
    val s = ExistXQDataSource()

    val conn = s.getConnection()
    println("Connexió feta")
    val sent = "for \$alumne in doc(\"/db/apps/classe.xml\")//alumne order by \$alumne/cognoms return \$alumne"

    val cons = conn.prepareExpression(sent)
    val rs = cons.executeQuery()

    var r_item: XQResultItem? = null
    while (rs.next()) {
        r_item = rs.getItem() as XQResultItem
        println(r_item.getItemAsString(null))
    }
}

