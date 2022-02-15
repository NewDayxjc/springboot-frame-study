package ${package.Entity}.vo;

<#if fileNameSuffix?contains('ListVO') || fileNameSuffix?contains('GetVO')>
    import com.irms.domain.vo.BaseVO;
</#if>
<#list table.importPackages as pkg>
    import ${pkg};
</#list>
<#if swagger??>
    import io.swagger.annotations.ApiModel;
    import io.swagger.annotations.ApiModelProperty;
</#if>
<#if entityLombokModel>
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    <#if chainModel>
        import lombok.experimental.Accessors;
    </#if>
</#if>

/**
* ${table.comment!}<#if fileNameSuffix?contains('List')>列表展示对象<#elseif fileNameSuffix?contains('Get')>详情展示对象<#else></#if>
*
<#if author != "">
    * @author ${author}
</#if>
<#if date != "">
    * @since ${date}
</#if>
*/
<#if table.convert>
    @TableName("${table.name}")
</#if>
<#if entityLombokModel>
    <#if fileNameSuffix?contains('ListVO') || fileNameSuffix?contains('GetVO')>
        @EqualsAndHashCode(callSuper = true)
    <#else>
        @EqualsAndHashCode(callSuper = false)
    </#if>
    <#if chainModel>
        @Accessors(chain = true)
    </#if>
    @Data
</#if>
<#if swagger??>
    @ApiModel(value = "${entity} <#if fileNameSuffix?contains('List')>列表展示对象<#elseif fileNameSuffix?contains('Get')>详情展示对象<#else></#if>", description = "${table.comment!}<#if fileNameSuffix?contains('List')>列表展示对象<#elseif fileNameSuffix?contains('Get')>详情展示对象<#else></#if>")
</#if>
<#if fileNameSuffix?contains("ListVO") || fileNameSuffix?contains('GetVO')>
    public class ${entity + fileNameSuffix} extends BaseVO {
<#elseif activeRecord>
    public class ${entity + fileNameSuffix} extends Model<${entity}> {
<#else>
    public class ${entity + fileNameSuffix} <#if entitySerialVersionUID>implements Serializable</#if> {
</#if>

<#if entitySerialVersionUID>
    private static final long serialVersionUID = 1L;

</#if>
<#-- ----------  BEGIN 字段循环遍历  -------- -->
<#list table.fields as field>
<#-- 排除公共字段 -->
    <#if field.propertyName != 'id' && field.propertyName != 'delFlag' && field.propertyName != 'createdTime' && field.propertyName != 'createdBy' && field.propertyName != 'updatedTime' && field.propertyName != 'updatedBy' && field.propertyName != 'remark'>
        <#if field.keyFlag>
            <#assign keyPropertyName="${field.propertyName}"/>
        </#if>
        <#if field.comment!?length gt 0>
            <#if swagger??>
                @ApiModelProperty("${field.comment}")
            <#else>
                /**
                * ${field.comment}
                */
            </#if>
        </#if>
        <#if field.keyFlag>
        <#-- 主键 -->
            <#if field.keyIdentityFlag>
                @TableId(value = "${field.annotationColumnName}", type = IdType.AUTO)
            <#elseif idType??>
                @TableId(value = "${field.annotationColumnName}", type = IdType.${idType})
            <#elseif field.convert>
                @TableId("${field.annotationColumnName}")
            </#if>
        <#-- 普通字段 -->
        <#elseif field.fill??>
        <#-- -----   存在字段填充设置   ----->
            <#if field.convert>
                @TableField(value = "${field.annotationColumnName}", fill = FieldFill.${field.fill})
            <#else>
                @TableField(fill = FieldFill.${field.fill})
            </#if>
        <#elseif field.convert>
            @TableField("${field.annotationColumnName}")
        </#if>
    <#-- 乐观锁注解 -->
        <#if field.versionField>
            @Version
        </#if>
    <#-- 逻辑删除注解 -->
        <#if field.logicDeleteField>
            @TableLogic
        </#if>
        private ${field.propertyType} ${field.propertyName};

    </#if>
</#list>
<#-- ----------  END 字段循环遍历  -------- -->
<#-- Lombok 模式 -->
<#if !entityLombokModel>
    <#list table.fields as field>
        <#if field.propertyType == "boolean">
            <#assign getprefix="is"/>
        <#else>
            <#assign getprefix="get"/>
        </#if>
        public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
        }

        <#if chainModel>
            public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        <#else>
            public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        </#if>
        this.${field.propertyName} = ${field.propertyName};
        <#if chainModel>
            return this;
        </#if>
        }
    </#list>
</#if>
<#-- 列常量 -->
<#if entityColumnConstant>
    <#list table.fields as field>
        public static final String ${field.name?upper_case} = "${field.name}";

    </#list>
</#if>
<#if activeRecord>
    @Override
    protected Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return null;
    </#if>
    }

</#if>
<#if !entityLombokModel>
    @Override
    public String toString() {
    return "${entity}{" +
    <#list table.fields as field>
        <#if field_index==0>
            "${field.propertyName}=" + ${field.propertyName} +
        <#else>
            ", ${field.propertyName}=" + ${field.propertyName} +
        </#if>
    </#list>
    "}";
    }
</#if>
}

