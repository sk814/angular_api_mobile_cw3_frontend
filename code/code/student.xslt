<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" indent="no"/>
	
	<xsl:template match="/">
	    <xsl:text>Name, cw1, project, final</xsl:text>
	 <xsl:text>&#xa;</xsl:text>
	    <xsl:apply-templates select="course/student"/>
	</xsl:template>
	
	<xsl:template match="student">
	   <xsl:value-of select="name"/>
	   <xsl:text>,</xsl:text>
	   <xsl:value-of select="cw1"/>
	   <xsl:text>,</xsl:text>
	   <xsl:value-of select="project"/>
	   <xsl:text>,</xsl:text>
	   <xsl:value-of select="final"/>
	</xsl:template>

	
</xsl:stylesheet>