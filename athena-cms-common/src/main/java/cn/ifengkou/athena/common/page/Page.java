package cn.ifengkou.athena.common.page;

/**
 * Created by Sloong on 2015/11/30.
 */
public class Page {
    private int rows = 10; //每页显示记录数
    private int totalResult;    //总记录数
    private int page = 1;    //当前页
    private int currentResult;  //当前记录起始索引
    private boolean entityOrField;  //true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性

    private String order;//排序字段
    private String sort = "DESC";//排序方式，DESC,ASC，默认为DESC

    public int getTotalPage() {
        float a = Float.parseFloat(Integer.toString(totalResult));
        float b = Float.parseFloat(Integer.toString(rows));
        Float flo =  a/b;
        int result =(int) Math.ceil(flo);
        return result;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;

    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getCurrentResult() {
        currentResult = (page-1) * rows;
        return currentResult;
    }
    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }
    public boolean isEntityOrField() {
        return entityOrField;
    }
    public void setEntityOrField(boolean entityOrField) {
        this.entityOrField = entityOrField;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
