package com.jg.core.client.appcontrol;


/**
 *
 */
public abstract class PageController<P extends Page<PageController>> {

    protected P page;
    protected String historyName;
    protected PageFlow pageFlow;

    protected PageController(String historyName, PageFlow pageFlow) {
        this.historyName = historyName;
        this.pageFlow = pageFlow;
    }

    public String getHistoryName() {
        return historyName;
    }


    public void setFocus() {
        getPage().setFocus();
    }

    public abstract P newInstance();

    public abstract void beforeLoad();

    public abstract void afterLoad();

    public abstract void unload();

    //lazy loading
    public P getPage() {
        if (page == null) {
            page = newInstance();
            page.setController(this);
            page.init();
        }
        return page;
    }


}
