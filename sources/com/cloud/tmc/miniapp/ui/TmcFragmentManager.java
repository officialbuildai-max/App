package com.cloud.tmc.miniapp.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cloud.tmc.integration.R;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppContext;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.PageContext;
import com.cloud.tmc.integration.ui.fragment.IFragmentManager;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.AppPrepareUtils;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TraceLog;
import com.cloud.tmc.miniutils.util.ViewUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TmcFragmentManager implements IFragmentManager {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_EXIT_PAGE = "exitPage";
    private static final int STACK_MAX_SIZE = 10;
    private static final String TAG = "TmcFragmentManager";
    private final WeakReference<FragmentActivity> activity;
    private TmcFragment currentFragment;
    private TmcFragment firstRemoveFragment;
    private LinkedHashMap<String, TmcFragment> fragmentMap;
    private final int layoutId;
    private final ArrayMap<String, TmcFragment> tabCacheFragmentManager;

    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TmcFragmentManager(FragmentActivity activity, int i11) {
        Intrinsics.h(activity, "activity");
        this.layoutId = i11;
        this.activity = new WeakReference<>(activity);
        this.fragmentMap = new LinkedHashMap<>();
        this.tabCacheFragmentManager = new ArrayMap<>(5);
    }

    private final boolean exitPage(String str, boolean z10, boolean z11) {
        TmcFragment tmcFragment;
        View view;
        androidx.fragment.app.w p11;
        androidx.fragment.app.w y10;
        Page page;
        boolean z12 = false;
        if (str != null && this.fragmentMap.containsKey(str)) {
            ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
            Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…terator(fragmentMap.size)");
            Object obj = "";
            boolean z13 = false;
            TmcFragment tmcFragment2 = null;
            while (listIterator.hasPrevious() && !z13) {
                Object previous = listIterator.previous();
                Intrinsics.g(previous, "iterator.previous()");
                Map.Entry entry = (Map.Entry) previous;
                TmcFragment remove = this.fragmentMap.remove(entry.getKey());
                if (Intrinsics.c(entry.getKey(), str)) {
                    obj = entry.getKey();
                    tmcFragment2 = remove;
                    z13 = true;
                } else {
                    tmcFragment2 = remove;
                }
            }
            if (this.fragmentMap.size() > 0) {
                ListIterator listIterator2 = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
                Intrinsics.g(listIterator2, "ArrayList<Map.Entry<Stri…entMap.size\n            )");
                TmcFragment tmcFragment3 = this.currentFragment;
                if (tmcFragment3 != null) {
                    Page page2 = tmcFragment3.getPage();
                    if (page2 != null) {
                        page2.hide();
                    }
                    tmcFragment3.onPause();
                    tmcFragment3.onStop();
                }
                this.currentFragment = (TmcFragment) ((Map.Entry) listIterator2.previous()).getValue();
                if (!((tmcFragment2 == null || (page = tmcFragment2.getPage()) == null) ? false : page.getBooleanValue("exitPage")) && (tmcFragment = this.currentFragment) != null) {
                    try {
                        FragmentManager innerManager = getInnerManager();
                        if (innerManager != null && (p11 = innerManager.p()) != null && (y10 = p11.y(tmcFragment)) != null) {
                            y10.l();
                        }
                        if (tmcFragment.isAdded() && !tmcFragment.isHidden() && !tmcFragment.isVisible() && (view = tmcFragment.getView()) != null) {
                            Intrinsics.g(view, "view");
                            ViewExtKt.toVisible(view);
                        }
                        Page page3 = tmcFragment.getPage();
                        if (page3 != null) {
                            page3.show();
                        }
                        tmcFragment.onStart();
                        tmcFragment.onResume();
                    } catch (Throwable th2) {
                        TmcLogger.e(TAG, "last page resume failed!", th2);
                    }
                }
                try {
                    removeFragment(tmcFragment2, z10);
                    FragmentManager innerManager2 = getInnerManager();
                    if (innerManager2 != null) {
                        if (innerManager2.T0()) {
                            try {
                                TraceLog.e("Tmcintegration", "isStateSaved is true , cant popBackStack");
                            } catch (Throwable th3) {
                                th = th3;
                                TmcLogger.e(TAG, "remove fragment failed!", th);
                                hideAddHomeTips();
                                return z12;
                            }
                        } else {
                            innerManager2.i1((String) obj, 1);
                            innerManager2.g0();
                        }
                    }
                    z12 = z13;
                } catch (Throwable th4) {
                    th = th4;
                    z12 = z13;
                }
            } else {
                if (this.fragmentMap.size() == 0 && z11) {
                    Iterator<Map.Entry<String, TmcFragment>> it = this.tabCacheFragmentManager.entrySet().iterator();
                    while (it.hasNext()) {
                        TmcFragment value = it.next().getValue();
                        try {
                            FragmentManager innerManager3 = getInnerManager();
                            if (innerManager3 != null && !innerManager3.L0()) {
                                if (innerManager3.T0()) {
                                    TraceLog.e("Tmcintegration", "isStateSaved is true , cant popBackStack");
                                    z13 = false;
                                } else {
                                    Page page4 = value.getPage();
                                    innerManager3.i1(page4 != null ? page4.getPageId() : null, 1);
                                    innerManager3.g0();
                                }
                            }
                            it.remove();
                        } catch (Throwable th5) {
                            TmcLogger.e(TAG, "fragment manager error", th5);
                        }
                    }
                    release();
                } else {
                    this.currentFragment = null;
                    Iterator<Map.Entry<String, TmcFragment>> it2 = this.tabCacheFragmentManager.entrySet().iterator();
                    while (it2.hasNext()) {
                        TmcFragment value2 = it2.next().getValue();
                        try {
                            FragmentManager innerManager4 = getInnerManager();
                            if (innerManager4 != null) {
                                if (innerManager4.T0()) {
                                    TraceLog.e("Tmcintegration", "isStateSaved is true , cant popBackStack");
                                    z13 = false;
                                } else {
                                    Page page5 = value2.getPage();
                                    innerManager4.i1(page5 != null ? page5.getPageId() : null, 1);
                                    innerManager4.g0();
                                }
                            }
                            it2.remove();
                        } catch (Throwable th6) {
                            TmcLogger.e(TAG, "remove tab fragment failed!", th6);
                        }
                    }
                    try {
                        FragmentManager innerManager5 = getInnerManager();
                        if ((innerManager5 == null || innerManager5.T0()) ? false : true) {
                            FragmentManager innerManager6 = getInnerManager();
                            if (innerManager6 != null) {
                                innerManager6.i1((String) obj, 1);
                            }
                        } else {
                            TraceLog.e("Tmcintegration", "isStateSaved is true , cant popBackStack");
                        }
                    } catch (Throwable th7) {
                        TmcLogger.e(TAG, "remove fragment popBackStack failed!", th7);
                    }
                }
                z12 = z13;
            }
            hideAddHomeTips();
        }
        return z12;
    }

    public static /* synthetic */ boolean exitPage$default(TmcFragmentManager tmcFragmentManager, String str, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return tmcFragmentManager.exitPage(str, z10, z11);
    }

    private final TmcFragment findFragmentForPage(String str) {
        if (str == null || !this.fragmentMap.containsKey(str)) {
            return null;
        }
        return this.fragmentMap.get(str);
    }

    private final void hideAddHomeTips() {
        Page page;
        App app;
        AppContext appContext;
        try {
            TmcFragment tmcFragment = this.currentFragment;
            Context context = (tmcFragment == null || (page = tmcFragment.getPage()) == null || (app = page.getApp()) == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
            MiniAppActivity miniAppActivity = context instanceof MiniAppActivity ? (MiniAppActivity) context : null;
            if (miniAppActivity != null) {
                miniAppActivity.hideAddHomeTips();
            }
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
    }

    private final void noticeTmcFragmentUpdate(App app) {
        androidx.fragment.app.w p11;
        androidx.fragment.app.w y10;
        try {
            Page activePage = app.getActivePage();
            if (activePage == null) {
                ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
                Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…ize\n                    )");
                if (listIterator.hasPrevious()) {
                    Object previous = listIterator.previous();
                    Intrinsics.g(previous, "iterator.previous()");
                    activePage = ((TmcFragment) ((Map.Entry) previous).getValue()).getPage();
                } else {
                    activePage = null;
                }
            }
            if (activePage != null) {
                PageContext pageContext = activePage.getPageContext();
                if (pageContext instanceof TmcFragment) {
                    TmcFragment tmcFragment = (TmcFragment) pageContext;
                    this.currentFragment = tmcFragment;
                    if (tmcFragment != null) {
                        try {
                            FragmentManager innerManager = getInnerManager();
                            if (innerManager != null && (p11 = innerManager.p()) != null && (y10 = p11.y(tmcFragment)) != null) {
                                y10.l();
                            }
                            Page page = tmcFragment.getPage();
                            if (page != null) {
                                page.show();
                            }
                            tmcFragment.onStart();
                            tmcFragment.onResume();
                        } catch (Throwable th2) {
                            TmcLogger.e(TAG, "notice fragment update failed!", th2);
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            TmcLogger.e(TAG, "noticeTmcFragmentUpdate is failed!", th3);
        }
    }

    private final void pushPage(String str, TmcFragment tmcFragment, int i11, boolean z10, boolean z11) {
        App app;
        androidx.fragment.app.w p11;
        Page page;
        if (str == null || tmcFragment == null) {
            return;
        }
        FragmentManager innerManager = getInnerManager();
        if (innerManager != null && (p11 = innerManager.p()) != null) {
            if (z10 && this.currentFragment != null) {
                p11.u(R.anim.in_from_right, R.anim.out_from_left, R.anim.in_from_left, R.anim.out_from_right);
            }
            TmcFragment tmcFragment2 = this.currentFragment;
            if (tmcFragment2 != null && (!z11 || ((page = tmcFragment2.getPage()) != null && page.isTabPage()))) {
                p11.p(tmcFragment2);
                tmcFragment2.onPause();
                tmcFragment2.onStop();
            }
            try {
                p11.c(i11, tmcFragment, str);
                p11.g(str);
                p11.j();
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "push fragment failed!", th2);
            }
        }
        this.fragmentMap.put(str, tmcFragment);
        this.currentFragment = tmcFragment;
        if (this.fragmentMap.size() > 10) {
            int size = this.fragmentMap.size() - 10;
            Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
            TmcFragment tmcFragment3 = null;
            while (it.hasNext() && size != 0) {
                Map.Entry<String, TmcFragment> next = it.next();
                Page page2 = next.getValue().getPage();
                if (page2 == null || !page2.isHomePage()) {
                    if (page2 == null || !page2.isTabPage()) {
                        if (this.firstRemoveFragment == null) {
                            this.firstRemoveFragment = next.getValue();
                        }
                        tmcFragment3 = next.getValue();
                        it.remove();
                        size--;
                    }
                }
            }
            Page page3 = tmcFragment3 != null ? tmcFragment3.getPage() : null;
            if (page3 != null && (app = page3.getApp()) != null) {
                int childCount = app.getChildCount() - 1;
                while (true) {
                    if (-1 >= childCount) {
                        break;
                    }
                    App app2 = page3.getApp();
                    Page pageByIndex = app2 != null ? app2.getPageByIndex(childCount) : null;
                    if (!Intrinsics.c(pageByIndex != null ? pageByIndex.getStringValue(TmcConstants.KEY_PAGE_PRE_ID) : null, page3.getPageId())) {
                        childCount--;
                    } else if (pageByIndex != null) {
                        pageByIndex.putBooleanValue("exitPage", true);
                    }
                }
            }
        }
        hideAddHomeTips();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeFragment$lambda$14(FragmentManager fm2, TmcFragment tmcFragment) {
        Intrinsics.h(fm2, "$fm");
        try {
            if (fm2.L0()) {
                return;
            }
            TmcLogger.d(TAG, "remove fragment after animation");
            fm2.p().r(tmcFragment).j();
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "remove fragment after animation failed", th2);
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public boolean attachFragment(TmcFragment tmcFragment, boolean z10) {
        androidx.fragment.app.w p11;
        if (tmcFragment != null) {
            try {
                FragmentManager innerManager = getInnerManager();
                if (innerManager != null && (p11 = innerManager.p()) != null) {
                    if (z10) {
                        p11.u(R.anim.in_from_right, R.anim.out_from_left, R.anim.in_from_left, R.anim.out_from_right);
                    }
                    p11.h(tmcFragment);
                    p11.j();
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "attach fragment error", th2);
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public synchronized void checkInvalidPage() {
        Page page;
        FragmentManager innerManager;
        boolean z10;
        TmcFragment tmcFragment = this.firstRemoveFragment;
        if (tmcFragment != null && (page = tmcFragment.getPage()) != null) {
            if (page.getPageId() == null) {
                return;
            }
            TmcLogger.d(TAG, "clear invalid page and remove fragment from fragment manager");
            try {
                innerManager = getInnerManager();
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "checkInvalidPage is failed!", th2);
            }
            if (innerManager == null || innerManager.T0()) {
                TraceLog.e("Tmcintegration", "isStateSaved is true , cant popBackStack");
                return;
            }
            FragmentManager innerManager2 = getInnerManager();
            if (innerManager2 != null) {
                innerManager2.i1(page.getPageId(), 1);
            }
            FragmentManager innerManager3 = getInnerManager();
            if (innerManager3 != null ? innerManager3.g0() : false) {
                this.firstRemoveFragment = null;
                App app = page.getApp();
                if (app == null) {
                    return;
                }
                int childCount = app.getChildCount() - 1;
                int i11 = childCount;
                while (true) {
                    if (-1 >= i11) {
                        z10 = false;
                        break;
                    }
                    Page pageByIndex = app.getPageByIndex(i11);
                    if (TextUtils.equals(page.getPageId(), pageByIndex != null ? pageByIndex.getPageId() : null)) {
                        z10 = true;
                        break;
                    }
                    i11--;
                }
                if (!z10) {
                    noticeTmcFragmentUpdate(app);
                    return;
                }
                ArrayList<Page> arrayList = new ArrayList();
                while (-1 < childCount) {
                    Page pageByIndex2 = app.getPageByIndex(childCount);
                    Page.AnimStore animStore = pageByIndex2 != null ? (Page.AnimStore) pageByIndex2.getData(Page.AnimStore.class, true) : null;
                    if (animStore != null) {
                        animStore.disableExit = true;
                    }
                    if (pageByIndex2 != null) {
                        arrayList.add(pageByIndex2);
                    }
                    if (TextUtils.equals(page.getPageId(), pageByIndex2 != null ? pageByIndex2.getPageId() : null)) {
                        break;
                    } else {
                        childCount--;
                    }
                }
                for (Page page2 : arrayList) {
                    page2.exit(false);
                    PageContext pageContext = page2.getPageContext();
                    TmcFragment tmcFragment2 = pageContext instanceof TmcFragment ? (TmcFragment) pageContext : null;
                    App app2 = page2.getApp();
                    removeFragment(tmcFragment2, ((app2 != null && app2.isExited()) || ((Page.AnimStore) page2.getData(Page.AnimStore.class, true)).disableExit) ? false : true);
                }
                noticeTmcFragmentUpdate(app);
            }
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public TmcFragment createFragment(Page page) {
        App app;
        App app2;
        return AppPrepareUtils.INSTANCE.isShellType((page == null || (app2 = page.getApp()) == null) ? null : app2.getAppModel()) ? new MiniShellFragment() : (page == null || (app = page.getApp()) == null || app.getPageType(page.getPagePath()) != 1) ? new MiniH5Fragment() : new MiniFragment();
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public boolean detachFragment(TmcFragment tmcFragment, boolean z10) {
        androidx.fragment.app.w p11;
        if (tmcFragment != null) {
            try {
                FragmentManager innerManager = getInnerManager();
                if (innerManager != null && (p11 = innerManager.p()) != null) {
                    if (z10) {
                        p11.u(R.anim.in_from_right, R.anim.out_from_left, R.anim.in_from_left, R.anim.out_from_right);
                    }
                    p11.m(tmcFragment);
                    p11.j();
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "detach fragment error", th2);
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public boolean exitPage(Page page, boolean z10, boolean z11) {
        return exitPage(page != null ? page.getPageId() : null, z10, z11);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public boolean exitTabCachePage(Page page, boolean z10) {
        TmcFragment remove;
        boolean z11;
        boolean removeFragment;
        String pagePath = page != null ? page.getPagePath() : null;
        if (pagePath == null || pagePath.length() == 0 || !this.tabCacheFragmentManager.containsKey(pagePath) || (remove = this.tabCacheFragmentManager.remove(pagePath)) == null) {
            return false;
        }
        Page page2 = remove.getPage();
        String pageId = page2 != null ? page2.getPageId() : null;
        try {
            removeFragment = removeFragment(remove, z10);
        } catch (Throwable th2) {
            th = th2;
            z11 = true;
        }
        try {
            FragmentManager innerManager = getInnerManager();
            if (innerManager != null && !innerManager.L0()) {
                if (innerManager.T0()) {
                    TraceLog.e("Tmcintegration", "isStateSaved is true , cant popBackStack");
                    return false;
                }
                innerManager.i1(pageId, 1);
                innerManager.g0();
            }
            return removeFragment;
        } catch (Throwable th3) {
            th = th3;
            z11 = removeFragment;
            TmcLogger.e(TAG, "fragment manager error", th);
            return z11;
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public TmcFragment findFragmentForPage(Page page) {
        return findFragmentForPage(page != null ? page.getPageId() : null);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public TmcFragment findFragmentPreForPage(Page page) {
        Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
        String str = "";
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<String, TmcFragment> next = it.next();
            if (Intrinsics.c(next.getKey(), page != null ? page.getPageId() : null)) {
                return this.fragmentMap.get(str);
            }
            str = next.getKey();
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public TmcFragment findHeaderFragment() {
        Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
        if (it.hasNext()) {
            return it.next().getValue();
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public TmcFragment findTabFragmentByPath(String str) {
        if (str == null || !this.tabCacheFragmentManager.containsKey(str)) {
            return null;
        }
        return this.tabCacheFragmentManager.get(str);
    }

    public final WeakReference<FragmentActivity> getActivity() {
        return this.activity;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public int getFragmentSize() {
        return this.fragmentMap.size();
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public Set<TmcFragment> getFragments() {
        Collection<TmcFragment> values = this.fragmentMap.values();
        Intrinsics.g(values, "fragmentMap.values");
        return CollectionsKt.W0(values);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public FragmentManager getInnerManager() {
        FragmentActivity fragmentActivity = this.activity.get();
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        return null;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public TmcFragment getReadyFragment() {
        return this.currentFragment;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public boolean isRootFragment(Page page) {
        return findFragmentForPage(page) != null && getFragmentSize() == 1;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public void moveTabPageToCache(List<Page> tabPages) {
        Intrinsics.h(tabPages, "tabPages");
        Iterator<Map.Entry<String, TmcFragment>> it = this.fragmentMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, TmcFragment> next = it.next();
            if (!(tabPages instanceof Collection) || !tabPages.isEmpty()) {
                Iterator<T> it2 = tabPages.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((Page) it2.next()).getPageId(), next.getKey())) {
                        ArrayMap<String, TmcFragment> arrayMap = this.tabCacheFragmentManager;
                        Page page = next.getValue().getPage();
                        arrayMap.put(page != null ? page.getPagePath() : null, next.getValue());
                        it.remove();
                    }
                }
            }
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public boolean onBackPressed() {
        FragmentManager innerManager;
        FragmentActivity fragmentActivity = this.activity.get();
        if (fragmentActivity == null || this.fragmentMap.size() == 0 || fragmentActivity.getSupportFragmentManager().r0() == 0) {
            return false;
        }
        ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
        Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…ap.size\n                )");
        if (listIterator.hasPrevious()) {
            this.fragmentMap.remove(((Map.Entry) listIterator.previous()).getKey());
        }
        if (this.fragmentMap.size() == 0 || (innerManager = getInnerManager()) == null || innerManager.T0()) {
            return false;
        }
        try {
            fragmentActivity.getSupportFragmentManager().g1();
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2);
        }
        return true;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public void pushPage(Page page, TmcFragment tmcFragment, int i11, boolean z10, boolean z11) {
        Intrinsics.h(page, "page");
        if (tmcFragment != null) {
            tmcFragment.setPage(page);
        }
        pushPage(page.getPageId(), tmcFragment, i11, z10, z11);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public void pushPage(Page page, TmcFragment tmcFragment, boolean z10, boolean z11) {
        Intrinsics.h(page, "page");
        pushPage(page, tmcFragment, this.layoutId, z10, z11);
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public void release() {
        this.activity.clear();
        this.fragmentMap.clear();
        this.tabCacheFragmentManager.clear();
        this.currentFragment = null;
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public boolean removeFragment(final TmcFragment tmcFragment, boolean z10) {
        final FragmentManager innerManager;
        if (tmcFragment == null || (innerManager = getInnerManager()) == null) {
            return false;
        }
        View view = tmcFragment.getView();
        if (!z10 || view == null) {
            innerManager.p().r(tmcFragment).j();
            return true;
        }
        try {
            view.animate().translationX(ViewUtils.isLayoutRtl() ? -view.getWidth() : view.getWidth()).setDuration(300L).withEndAction(new Runnable() { // from class: com.cloud.tmc.miniapp.ui.q1
                @Override // java.lang.Runnable
                public final void run() {
                    TmcFragmentManager.removeFragment$lambda$14(FragmentManager.this, tmcFragment);
                }
            }).start();
            return true;
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "remove fragment with animation error", th2);
            return false;
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public void resetFragmentToTop(TmcFragment tmcFragment) {
        if (tmcFragment == null) {
            TraceLog.w("Tmcintegration", "resetFragment can not null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = new ArrayList(this.fragmentMap.entrySet()).listIterator(this.fragmentMap.size());
        Intrinsics.g(listIterator, "ArrayList<Map.Entry<Stri…terator(fragmentMap.size)");
        boolean z10 = false;
        while (listIterator.hasPrevious() && !z10) {
            Object previous = listIterator.previous();
            Intrinsics.g(previous, "iterator.previous()");
            Map.Entry entry = (Map.Entry) previous;
            if (Intrinsics.c(entry.getValue(), tmcFragment)) {
                FragmentManager innerManager = getInnerManager();
                if (innerManager == null || innerManager.T0()) {
                    TraceLog.e("Tmcintegration", "isStateSaved is true , cant popBackStack");
                    return;
                }
                FragmentManager innerManager2 = getInnerManager();
                if (innerManager2 != null) {
                    innerManager2.i1((String) entry.getKey(), 0);
                }
                this.currentFragment = tmcFragment;
                z10 = true;
            } else {
                arrayList.add(entry.getKey());
            }
        }
        if (!z10) {
            TraceLog.w("Tmcintegration", "reset fragment is not exist");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.fragmentMap.remove((String) it.next());
        }
    }

    @Override // com.cloud.tmc.integration.ui.fragment.IFragmentManager
    public void switchTab(Page page, TmcFragment tmcFragment) {
        androidx.fragment.app.w p11;
        Intrinsics.h(page, "page");
        if (this.tabCacheFragmentManager.containsKey(page.getPagePath())) {
            this.tabCacheFragmentManager.remove(page.getPagePath());
            String pageId = page.getPageId();
            if (pageId == null || tmcFragment == null) {
                return;
            }
            this.fragmentMap.put(pageId, tmcFragment);
            try {
                FragmentManager innerManager = getInnerManager();
                if (innerManager != null && (p11 = innerManager.p()) != null) {
                    TmcFragment tmcFragment2 = this.currentFragment;
                    if (tmcFragment2 != null) {
                        p11.p(tmcFragment2);
                    }
                    p11.y(tmcFragment);
                    p11.l();
                }
            } catch (Throwable th2) {
                TmcLogger.e(TAG, "switch tab fragment failed!", th2);
            }
            TmcFragment tmcFragment3 = this.currentFragment;
            if (tmcFragment3 != null) {
                tmcFragment3.onPause();
                tmcFragment3.onStop();
            }
            this.currentFragment = tmcFragment;
            tmcFragment.onStart();
            tmcFragment.onResume();
        }
        hideAddHomeTips();
    }
}
