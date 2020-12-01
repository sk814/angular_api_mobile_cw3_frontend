<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>
					<center>RESTController
					</center>
				</h2>
				<table border="1">
					<tr bgcolor="yellow">
						<th>Operation</th>
						<th>Argument(s)</th>
						<th>Return</th>
					</tr>
					<xsl:for-each select="interface/abstract_method">
						<tr>
							<td>
								<b>
									<xsl:value-of select="@name" />
								</b>
							</td>
							<td>
								<xsl:for-each select="arguments/parameter">
									<xsl:value-of select="." />
									<xsl:text>: </xsl:text>
									<xsl:value-of select="@type" />
									<xsl:choose>
										<xsl:when test="position() != last()">
											,
										</xsl:when>
									</xsl:choose>

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