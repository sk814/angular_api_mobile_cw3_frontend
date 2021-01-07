<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
<html>
<body>
<h1>RESTController</h1>
<table>
<tr bgcolor="yellow">
<th><center>Operation</center></th>
<th><center>Argument(s)</center></th>
<th><center>Return</center></th>
</tr>
<xsl:for-each select="interface/abstract_method">
<tr>
<td>
<b><xsl:value-of select="@name" /></b>
</td>
<td>
<xsl:for-each select="arguments/parameter">
<xsl:value-of select="." />
<xsl:text>: </xsl:text>
<xsl:value-of select="@type" />
      <xsl:if test="position()!=last()">           
      <xsl:text>,</xsl:text>
      </xsl:if>
</xsl:for-each>
</td>
<td>
<xsl:value-of select="return" />
</td>
</tr>
</xsl:for-each>

</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
