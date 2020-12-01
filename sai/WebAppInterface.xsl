<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				RESTController
				<table border="2">
					<tr bgcolor="blue">
						<th>
							<xsl:text>Operation</xsl:text>
						</th>
						<th>
							<xsl:text>Argument(s)</xsl:text>
						</th>
						<th>
							<xsl:text>Return</xsl:text>
						</th>
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
									<xsl:value-of select="current()" />
									: 
									<xsl:value-of select="@type" />
									<xsl:choose>
										<xsl:when test="position() = 1">
											<xsl:text>, </xsl:text>
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