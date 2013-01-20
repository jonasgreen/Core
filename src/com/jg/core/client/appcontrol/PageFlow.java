package com.jg.core.client.appcontrol;


import com.google.gwt.user.client.ui.RootLayoutPanel;


/**
 *
 */
public class PageFlow {
    private static PageFlow instance;

    private RootLayoutPanel rootContent = RootLayoutPanel.get();
    private PageController activeController = null;

    public static void show(PageController pc) {
        getInstance().doShow(pc);
    }

    private void doShow(PageController pc){
        if(activeController != null){
            activeController.unload();
            Page<PageController> page = activeController.getPage();
            page.removeFromParent();
        }

        activeController = pc;
        pc.beforeLoad();
        rootContent.add(pc.getPage());
        pc.afterLoad();
    }


    private static PageFlow getInstance() {
        if (instance == null) {
            instance = new PageFlow();
        }
        return instance;
    }


}
