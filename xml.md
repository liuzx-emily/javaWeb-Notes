- eXtensible Markup Language：可扩展标记型语言
	- 可扩展：xml的标签可以自己定义，可以写中文标签：`<狗></狗>`
	- 标记型：用"标签"

- 用途：存储数据，最常用作配置文件

- XML的约束：dtd约束、schema约束

-  CDATA区  
	`<![CDATA[内容]]>`可以解决多个字符都需要转义的操作，把这些内容放到CDATA区中，就不需要转义了。

	- PCDATA：parsed character data（会被解析的文本）
	- CDATA：character data（不会被解析的文本）




---




## XML的解析
解析方式（技术）：dom和sax	

想要解析xml，首先需要解析器
  不同的公司和组织，针对dom和sax方式，提供了不同的解析器，通过api方式提供
  sun公司：	jaxp
  dom4j组织：dom4j（最常用）