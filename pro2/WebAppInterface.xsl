<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h3>
					<b>RESTController</b>
				</h3>
				<table border="5">

					<tr>
						<th style="text-align:center" bgcolor="yellow">Operation</th>
						<th style="text-align:center" bgcolor="yellow">Argument(s)</th>
						<th style="text-align:center" bgcolor="yellow">Return</th>
					</tr>

					<xsl:for-each select="interface/abstract_method">
						<tr>
							<td>
								<xsl:value-of select="@name" />
							</td>
							<td>
								<xsl:for-each select="arguments/parameter">
									<xsl:value-of select="current()" />
									<xsl:text>: </xsl:text>
									<xsl:value-of select="@type" />
									<xsl:choose>
										<xsl:when test="position() = 1">
											<xsl:choose>
												<xsl:when test="position() != last() ">
													<xsl:text>, </xsl:text>
												</xsl:when>
											</xsl:choose>
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
