package lk;

import android.app.Activity;
import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupInfo;
import com.transsion.bean.HomePopupRequestEntity;
import com.transsion.commercialization.dialog.TaskCommonDialog;
import com.transsion.commercialization.dialog.TrendingFloatView;
import com.transsion.commercializationapi.ICommonDialogApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import ti.p;

/* loaded from: classes6.dex */
public final class c implements ICommonDialogApi {

    /* renamed from: d, reason: collision with root package name */
    public static final a f69077d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private TrendingFloatView f69078a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f69079b = LazyKt.b(new Function0() { // from class: lk.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            c.d();
            return null;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f69080c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ e d() {
        i();
        return null;
    }

    private final String e() {
        String simpleName = c.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final List f(HomePopupEntity homePopupEntity, boolean z10, String str) {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        String string = bVar.b().getString("global_dialog_date", "");
        String b11 = p.b(p.f76389a, Long.valueOf((homePopupEntity != null ? homePopupEntity.getTs() : 0L) * 1000), null, 2, null);
        if (TextUtils.equals(b11, string) || !z10) {
            String string2 = Intrinsics.c(str, "popup") ? bVar.b().getString("global_dialog_history", null) : bVar.b().getString("global_widget_history", null);
            if (string2 == null) {
                return new ArrayList();
            }
            Object e11 = o.e(string2, o.g(HomePopupRequestEntity.class));
            Intrinsics.g(e11, "fromJson(...)");
            return (List) e11;
        }
        a.C0856a.l(lg.a.f68962a, "zxb_popup", e() + " --> getDialogRecord() --> 不是同一天数据，return mutableListOf() --> currentDate = " + b11 + " -- globalDialogDate = " + string + " --> 不是同一天数据，需要清空本地保存的数据", false, 4, null);
        if (Intrinsics.c(str, "popup")) {
            bVar.b().putString("global_dialog_history", null);
        } else {
            bVar.b().putString("global_widget_history", null);
        }
        return new ArrayList();
    }

    static /* synthetic */ List g(c cVar, HomePopupEntity homePopupEntity, boolean z10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            str = "popup";
        }
        return cVar.f(homePopupEntity, z10, str);
    }

    private final void h(HomePopupEntity homePopupEntity, String str) {
        HomePopupInfo widget;
        HomePopupInfo homePopupInfo;
        if (Intrinsics.c(str, "popup")) {
            if (homePopupEntity != null) {
                widget = homePopupEntity.getPopup();
                homePopupInfo = widget;
            }
            homePopupInfo = null;
        } else {
            if (homePopupEntity != null) {
                widget = homePopupEntity.getWidget();
                homePopupInfo = widget;
            }
            homePopupInfo = null;
        }
        if (homePopupInfo == null) {
            a.C0856a.l(lg.a.f68962a, "zxb_popup", e() + " --> saveDialogRecord() --> popup == null --> 保存数据异常 -- type = " + str, false, 4, null);
            return;
        }
        List<HomePopupRequestEntity> g11 = g(this, homePopupEntity, false, str, 2, null);
        HomePopupRequestEntity homePopupRequestEntity = null;
        for (HomePopupRequestEntity homePopupRequestEntity2 : g11) {
            if (homePopupRequestEntity2 != null && homePopupRequestEntity2.getId() == homePopupInfo.getId()) {
                homePopupRequestEntity = homePopupRequestEntity2;
            }
        }
        if (homePopupRequestEntity == null) {
            g11.add(new HomePopupRequestEntity(homePopupInfo.getId(), Long.valueOf(homePopupEntity != null ? homePopupEntity.getTs() : 0L), 1));
        } else {
            homePopupRequestEntity.setCount(homePopupRequestEntity.getCount() + 1);
            homePopupRequestEntity.setTs(homePopupEntity != null ? Long.valueOf(homePopupEntity.getTs()) : null);
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        bVar.b().putString(Intrinsics.c(str, "popup") ? "global_dialog_history" : "global_widget_history", o.j(g11));
        bVar.b().putString("global_dialog_date", p.b(p.f76389a, Long.valueOf((homePopupEntity != null ? homePopupEntity.getTs() : 0L) * 1000), null, 2, null));
        a.C0856a.f(lg.a.f68962a, "zxb_popup", e() + " --> saveDialogRecord() --> type = " + str + " --> 展示记录保存 --> homePopup = " + homePopupEntity, false, 4, null);
    }

    private static final e i() {
        android.support.v4.media.session.c.a(zg.c.f79537e.a().h(e.class));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(HomePopupEntity homePopupEntity, Function1 function1, Activity activity) {
        new TaskCommonDialog().x0(homePopupEntity).w0(function1).k0(activity, "TaskCommonDialog");
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void a(HomePopupEntity homePopupEntity) {
        h(homePopupEntity, "widget");
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void b(final HomePopupEntity homePopupEntity, final Function1 callback) {
        Intrinsics.h(callback, "callback");
        final Activity b11 = com.blankj.utilcode.util.a.b();
        if (b11 != null) {
            b11.runOnUiThread(new Runnable() { // from class: lk.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.j(HomePopupEntity.this, callback, b11);
                }
            });
        }
    }

    @Override // com.transsion.commercializationapi.ICommonDialogApi
    public void onDestroy() {
        this.f69078a = null;
        WeakReference weakReference = this.f69080c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f69080c = null;
    }
}
