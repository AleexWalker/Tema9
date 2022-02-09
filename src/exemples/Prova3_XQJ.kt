package exemples

import net.xqj.exist.ExistXQDataSource
import javax.xml.xquery.XQResultItem
import javax.xml.xquery.XQConstants

fun main() {
    val s = ExistXQDataSource()

    val conn = s.getConnection()
    println("Connexió feta")
    val sent = "for \$alumne in //alumne order by \$alumne/cognoms return \$alumne"

    val cntxt = conn.getStaticContext()
    cntxt.setScrollability(XQConstants.SCROLLTYPE_SCROLLABLE)
    conn.setStaticContext(cntxt)
    val cons = conn.prepareExpression(sent)

    val rs = cons.executeQuery()
    rs.afterLast()
    while (rs.previous())
        println(rs.getItemAsString(null))

    conn.close()
}

