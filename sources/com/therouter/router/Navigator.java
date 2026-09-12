package com.therouter.router;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.therouter.TheRouter;
import com.therouter.TheRouterKt;
import com.therouter.history.HistoryRecorder;
import com.therouter.router.action.ActionManager;
import com.transsion.gslb.Utils;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;

/* loaded from: classes5.dex */
public class Navigator {

    /* renamed from: a */
    private String f40810a;

    /* renamed from: b */
    private final Intent f40811b;

    /* renamed from: c */
    private final String f40812c;

    /* renamed from: d */
    private String f40813d;

    /* renamed from: e */
    private final Bundle f40814e;

    /* renamed from: f */
    private final HashMap f40815f;

    /* renamed from: g */
    private Bundle f40816g;

    /* renamed from: h */
    private boolean f40817h;

    /* renamed from: i */
    private String f40818i;

    /* renamed from: j */
    private Uri f40819j;

    /* renamed from: k */
    private ClipData f40820k;

    public Navigator(String str) {
        this(str, null);
    }

    public Navigator(String str, Intent intent) {
        List<bg.d> list;
        this.f40810a = str;
        this.f40811b = intent;
        this.f40812c = str;
        this.f40813d = "";
        this.f40814e = new Bundle();
        this.f40815f = new HashMap();
        TheRouterKt.h(!TextUtils.isEmpty(this.f40810a), "Navigator", "Navigator constructor parameter url is empty");
        list = NavigatorKt.f40823c;
        for (bg.d dVar : list) {
            if (dVar != null && dVar.b(this.f40810a)) {
                this.f40810a = dVar.a(this.f40810a);
            }
        }
        String str2 = this.f40810a;
        this.f40813d = str2 == null ? "" : str2;
        Uri parse = Uri.parse(str2 != null ? str2 : "");
        c(this, parse.getEncodedFragment());
        c(this, parse.getEncodedQuery());
    }

    private static final void a(Navigator navigator, String str, String str2) {
        String substring;
        if (str == null || StringsKt.q0(str) || Intrinsics.c(StringsKt.n1(str).toString(), UrlUtils.EQUAL_MARK)) {
            return;
        }
        int o02 = StringsKt.o0(str, UrlUtils.EQUAL_MARK, 0, false, 6, null);
        String str3 = "";
        if (o02 != -1) {
            if (o02 != 0) {
                str3 = str.substring(0, o02);
                Intrinsics.g(str3, "substring(...)");
                substring = str.substring(o02 + 1);
                Intrinsics.g(substring, "substring(...)");
            } else {
                substring = str.substring(1);
                Intrinsics.g(substring, "substring(...)");
            }
            String str4 = str3;
            str3 = substring;
            str = str4;
        }
        if (!TextUtils.isEmpty(str2 != null ? StringsKt.n1(str2).toString() : null)) {
            str3 = str3 + str2;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str3)) {
            return;
        }
        navigator.f40815f.put(str, str3);
    }

    static /* synthetic */ void b(Navigator navigator, String str, String str2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: _init_$parser");
        }
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        a(navigator, str, str2);
    }

    private static final void c(Navigator navigator, String str) {
        List S0;
        if (str == null || !StringsKt.b0(str, '?', false, 2, null)) {
            if (str == null || (S0 = StringsKt.S0(str, new String[]{UrlUtils.AND_MARK}, false, 0, 6, null)) == null) {
                return;
            }
            Iterator it = S0.iterator();
            while (it.hasNext()) {
                b(navigator, (String) it.next(), null, 4, null);
            }
            return;
        }
        int n02 = StringsKt.n0(str, '?', 0, false, 6, null);
        if (n02 > -1) {
            String substring = str.substring(0, n02);
            Intrinsics.g(substring, "substring(...)");
            String substring2 = str.substring(n02 + 1);
            Intrinsics.g(substring2, "substring(...)");
            List R0 = StringsKt.R0(substring, new char[]{'&'}, false, 0, 6, null);
            if (R0.isEmpty()) {
                return;
            }
            int size = R0.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (i11 == R0.size() - 1) {
                    a(navigator, (String) R0.get(i11), substring2);
                } else {
                    b(navigator, (String) R0.get(i11), null, 4, null);
                }
            }
        }
    }

    public static /* synthetic */ void w(Navigator navigator, Context context, int i11, bg.c cVar, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i12 & 4) != 0) {
            cVar = null;
        }
        navigator.s(context, i11, cVar);
    }

    public static /* synthetic */ void x(Navigator navigator, Context context, bg.c cVar, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i11 & 1) != 0) {
            context = com.therouter.c.c();
        }
        if ((i11 & 2) != 0) {
            cVar = null;
        }
        navigator.u(context, cVar);
    }

    public static /* synthetic */ void y(Navigator navigator, Fragment fragment, int i11, bg.c cVar, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigation");
        }
        if ((i12 & 4) != 0) {
            cVar = null;
        }
        navigator.v(fragment, i11, cVar);
    }

    public final Navigator A(String str, Bundle bundle) {
        this.f40814e.putBundle(str, bundle);
        return this;
    }

    public final Navigator B(String str, byte b11) {
        this.f40814e.putByte(str, b11);
        return this;
    }

    public final Navigator C(String str, char c11) {
        this.f40814e.putChar(str, c11);
        return this;
    }

    public final Navigator D(String str, double d11) {
        this.f40814e.putDouble(str, d11);
        return this;
    }

    public final Navigator E(String str, float f11) {
        this.f40814e.putFloat(str, f11);
        return this;
    }

    public final Navigator F(String str, int i11) {
        this.f40814e.putInt(str, i11);
        return this;
    }

    public final Navigator G(String str, long j11) {
        this.f40814e.putLong(str, j11);
        return this;
    }

    public final Navigator H(String key, Object value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        NavigatorKt.j().put(key, new SoftReference(value));
        return this;
    }

    public final Navigator I(String str, Parcelable parcelable) {
        this.f40814e.putParcelable(str, parcelable);
        return this;
    }

    public final Navigator J(String str, Serializable serializable) {
        this.f40814e.putSerializable(str, serializable);
        return this;
    }

    public final Navigator K(String str, String str2) {
        this.f40814e.putString(str, str2);
        return this;
    }

    public final void i(Context context) {
        if (ActionManager.f40832a.d(this)) {
            x(this, context, null, 2, null);
        }
    }

    public final Navigator j(int i11) {
        Bundle bundle = this.f40814e;
        bundle.putInt("therouter_intent_flags", i11 | bundle.getInt("therouter_intent_flags", 0));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Fragment k() {
        List<bg.e> list;
        List<bg.g> list2;
        Function2 function2;
        Bundle extras;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TheRouterKt.d("Navigator::navigationFragment", "begin navigate " + o(), null, 4, null);
        String o11 = o();
        list = NavigatorKt.f40824d;
        for (bg.e eVar : list) {
            if (eVar != null && eVar.c(o11)) {
                o11 = eVar.b(o11);
            }
        }
        TheRouterKt.d("Navigator::navigationFragment", "path replace to " + ((Object) o11), null, 4, null);
        RouteItem k11 = RouteMapKt.k(o11);
        if (k11 != null && (extras = k11.getExtras()) != null) {
            extras.putAll(this.f40814e);
            Set<String> keySet = this.f40815f.keySet();
            Intrinsics.g(keySet, "<get-keys>(...)");
            for (String str : keySet) {
                if (!extras.containsKey(str)) {
                    extras.putString(str, (String) this.f40815f.get(str));
                }
            }
        }
        if (k11 != null) {
            TheRouterKt.d("Navigator::navigationFragment", "match route " + k11, null, 4, null);
        }
        list2 = NavigatorKt.f40825e;
        for (bg.g gVar : list2) {
            if (gVar != null && gVar.b(k11)) {
                k11 = gVar.a(k11);
            }
        }
        TheRouterKt.d("Navigator::navigationFragment", "route replace to " + k11, null, 4, null);
        if (k11 != null) {
            function2 = NavigatorKt.f40827g;
            function2.invoke(k11, new Function1<RouteItem, Unit>() { // from class: com.therouter.router.Navigator$createFragment$5$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RouteItem) obj);
                    return Unit.f67184a;
                }

                /* JADX WARN: Type inference failed for: r1v3, types: [T, androidx.fragment.app.Fragment] */
                public final void invoke(RouteItem routeItem) {
                    Bundle extras2;
                    Intrinsics.h(routeItem, "routeItem");
                    if (!c.b(routeItem.getClassName())) {
                        if (TheRouter.m()) {
                            throw new RuntimeException("TheRouter::Navigator " + routeItem.getClassName() + " is not Fragment");
                        }
                        return;
                    }
                    try {
                        objectRef.element = c.a(routeItem.getClassName());
                        Bundle extras3 = routeItem.getExtras();
                        Intent n11 = this.n();
                        if (n11 != null && (extras2 = n11.getExtras()) != null) {
                            extras3.putAll(extras2);
                        }
                        extras3.putString("therouter_action", routeItem.getAction());
                        extras3.putString("therouter_path", this.p());
                        extras3.putString("therouter_description", routeItem.getDescription());
                        Fragment fragment = objectRef.element;
                        if (fragment != null) {
                            fragment.setArguments(extras3);
                        }
                        TheRouterKt.d("Navigator::navigation", "create fragment " + routeItem.getClassName(), null, 4, null);
                    } catch (Exception e11) {
                        TheRouterKt.c("Navigator::navigationFragment", "create fragment instance error " + e11.getMessage(), new Function0<Unit>() { // from class: com.therouter.router.Navigator$createFragment$5$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m855invoke();
                                return Unit.f67184a;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m855invoke() {
                                e11.printStackTrace();
                            }
                        });
                    }
                    HistoryRecorder.c(new com.therouter.history.c(this.p()));
                }
            });
        }
        return (Fragment) objectRef.element;
    }

    public final Intent l(final Context context) {
        List<bg.e> list;
        List<bg.g> list2;
        Function2 function2;
        Bundle extras;
        TheRouterKt.d("Navigator::createIntent", "begin navigate " + o(), null, 4, null);
        if (context == null) {
            context = com.therouter.c.c();
        }
        String o11 = o();
        list = NavigatorKt.f40824d;
        for (bg.e eVar : list) {
            if (eVar != null && eVar.c(o11)) {
                String b11 = eVar.b(o11);
                TheRouterKt.d("Navigator::createIntent", o11 + " replace to " + ((Object) b11), null, 4, null);
                o11 = b11;
            }
        }
        RouteItem k11 = RouteMapKt.k(o11);
        if (k11 != null && (extras = k11.getExtras()) != null) {
            extras.putAll(this.f40814e);
            Set<String> keySet = this.f40815f.keySet();
            Intrinsics.g(keySet, "<get-keys>(...)");
            for (String str : keySet) {
                if (!extras.containsKey(str)) {
                    extras.putString(str, (String) this.f40815f.get(str));
                }
            }
        }
        if (k11 != null) {
            TheRouterKt.d("Navigator::createIntent", "match route " + k11, null, 4, null);
        }
        list2 = NavigatorKt.f40825e;
        for (bg.g gVar : list2) {
            if (gVar != null && gVar.b(k11) && (k11 = gVar.a(k11)) != null) {
                TheRouterKt.d("Navigator::createIntent", "route replace to " + k11, null, 4, null);
            }
        }
        final Intent intent = this.f40811b;
        if (intent == null) {
            intent = new Intent();
        }
        if (k11 != null) {
            function2 = NavigatorKt.f40827g;
            function2.invoke(k11, new Function1<RouteItem, Unit>() { // from class: com.therouter.router.Navigator$createIntent$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RouteItem) obj);
                    return Unit.f67184a;
                }

                public final void invoke(final RouteItem routeItem) {
                    Uri uri;
                    ClipData clipData;
                    ComponentName componentName;
                    String str2;
                    String str3;
                    Intrinsics.h(routeItem, "routeItem");
                    uri = Navigator.this.f40819j;
                    if (uri != null) {
                        intent.setData(uri);
                    }
                    clipData = Navigator.this.f40820k;
                    if (clipData != null) {
                        intent.setClipData(clipData);
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        str2 = Navigator.this.f40818i;
                        if (str2 != null) {
                            Intent intent2 = intent;
                            str3 = Navigator.this.f40818i;
                            intent2.setIdentifier(str3);
                        }
                    }
                    Intent intent3 = intent;
                    Context context2 = context;
                    if (context2 != null) {
                        componentName = new ComponentName(context2.getPackageName(), routeItem.getClassName());
                    } else {
                        Navigator navigator = Navigator.this;
                        if (TheRouter.m()) {
                            throw new RuntimeException("context is null, path is -> " + navigator.p());
                        }
                        TheRouterKt.d("Navigator::createIntent", "context is null, path is -> " + navigator.p(), null, 4, null);
                        componentName = null;
                    }
                    intent3.setComponent(componentName);
                    if (!(context instanceof Activity)) {
                        intent.addFlags(ASTNode.DEOP);
                    }
                    com.therouter.f fVar = com.therouter.f.f40783a;
                    String className = routeItem.getClassName();
                    final Navigator navigator2 = Navigator.this;
                    fVar.a(className, new Function1<Activity, Unit>() { // from class: com.therouter.router.Navigator$createIntent$5.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Activity) obj);
                            return Unit.f67184a;
                        }

                        public final void invoke(Activity it) {
                            Intrinsics.h(it, "it");
                            if (!Intrinsics.c(it.getClass().getName(), RouteItem.this.getClassName()) || TextUtils.isEmpty(RouteItem.this.getAction())) {
                                return;
                            }
                            TheRouter.c(RouteItem.this.getAction()).H("therouter_object_navigator", navigator2).H("therouter_object_current_activity", it).i(it);
                        }
                    });
                    intent.putExtra("therouter_action", routeItem.getAction());
                    intent.putExtra("therouter_path", Navigator.this.p());
                    intent.putExtra("therouter_description", routeItem.getDescription());
                    Bundle extras2 = routeItem.getExtras();
                    Intent intent4 = intent;
                    Bundle bundle = extras2.getBundle("therouter_bundle");
                    if (bundle != null) {
                        extras2.remove("therouter_bundle");
                        intent4.putExtra("therouter_bundle", bundle);
                    }
                    intent4.putExtras(extras2);
                    intent.addFlags(routeItem.getExtras().getInt("therouter_intent_flags"));
                    int i11 = routeItem.getExtras().getInt("therouter_intent_animation_in");
                    int i12 = routeItem.getExtras().getInt("therouter_intent_animation_out");
                    if (i11 == 0 && i12 == 0) {
                        return;
                    }
                    if (!(context instanceof Activity)) {
                        if (TheRouter.m()) {
                            throw new RuntimeException("Navigator::createIntent context is not Activity, ignore animation");
                        }
                        return;
                    }
                    TheRouterKt.d("Navigator::createIntent", "overridePendingTransition " + routeItem.getClassName(), null, 4, null);
                    ((Activity) context).overridePendingTransition(routeItem.getExtras().getInt("therouter_intent_animation_in"), routeItem.getExtras().getInt("therouter_intent_animation_out"));
                }
            });
        }
        return intent;
    }

    public final Bundle m() {
        return this.f40814e;
    }

    public final Intent n() {
        return this.f40811b;
    }

    public final String o() {
        String str = this.f40810a;
        if (str == null) {
            str = "";
        }
        if (!StringsKt.c0(str, UrlUtils.QUESTION_MARK, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, StringsKt.n0(str, '?', 0, false, 6, null));
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public final String p() {
        return q(new Function2<String, String, String>() { // from class: com.therouter.router.Navigator$getUrlWithParams$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String k11, String v11) {
                Intrinsics.h(k11, "k");
                Intrinsics.h(v11, "v");
                return k11 + UrlUtils.EQUAL_MARK + v11;
            }
        });
    }

    public final String q(Function2 handle) {
        String str;
        Object obj;
        Object obj2;
        Intrinsics.h(handle, "handle");
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = this.f40814e.keySet().iterator();
        boolean z10 = true;
        while (true) {
            Object obj3 = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (!this.f40815f.containsKey(next)) {
                Intrinsics.e(next);
                Object obj4 = this.f40814e.get(next);
                if (obj4 == null || (obj = obj4.toString()) == null) {
                    obj = "";
                }
                String str2 = (String) handle.invoke(next, obj);
                if (!TextUtils.isEmpty(str2)) {
                    if (z10) {
                        sb2.append(str2);
                        z10 = false;
                    } else {
                        sb2.append('&');
                        Object obj5 = this.f40814e.get(next);
                        if (obj5 != null && (obj2 = obj5.toString()) != null) {
                            obj3 = obj2;
                        }
                        sb2.append((String) handle.invoke(next, obj3));
                    }
                }
            }
        }
        Uri parse = Uri.parse(this.f40813d);
        String encodedQuery = parse.getEncodedQuery();
        String str3 = encodedQuery == null ? "" : encodedQuery;
        String encodedFragment = parse.getEncodedFragment();
        String str4 = encodedFragment == null ? "" : encodedFragment;
        if (TextUtils.isEmpty(sb2)) {
            str = this.f40813d;
        } else if (!TextUtils.isEmpty(str3)) {
            if (!StringsKt.V0(str3, '&', false, 2, null)) {
                sb2.append('&');
            }
            sb2.append(str3);
            String str5 = this.f40813d;
            String sb3 = sb2.toString();
            Intrinsics.g(sb3, "toString(...)");
            str = StringsKt.Q(str5, str3, sb3, false, 4, null);
        } else if (!TextUtils.isEmpty(str4)) {
            int o02 = StringsKt.o0(this.f40813d, str4, 0, false, 6, null);
            if (o02 > -1) {
                String substring = this.f40813d.substring(0, o02);
                Intrinsics.g(substring, "substring(...)");
                str = StringsKt.b0(substring, '?', false, 2, null) ? StringsKt.Q(this.f40813d, UrlUtils.QUESTION_MARK, UrlUtils.QUESTION_MARK + ((Object) sb2), false, 4, null) : StringsKt.Q(this.f40813d, Utils.SEPARATOR, UrlUtils.QUESTION_MARK + ((Object) sb2) + Utils.SEPARATOR, false, 4, null);
            } else {
                str = this.f40813d;
            }
        } else if (StringsKt.b0(this.f40813d, '?', false, 2, null)) {
            str = StringsKt.Q(this.f40813d, UrlUtils.QUESTION_MARK, UrlUtils.QUESTION_MARK + ((Object) sb2), false, 4, null);
        } else {
            str = this.f40813d + UrlUtils.QUESTION_MARK + ((Object) sb2);
        }
        Set<String> keySet = this.f40815f.keySet();
        Intrinsics.g(keySet, "<get-keys>(...)");
        while (true) {
            String str6 = str;
            for (String str7 : keySet) {
                if (this.f40814e.containsKey(str7)) {
                    break;
                }
            }
            return str6;
            str = StringsKt.Q(str6, str7 + UrlUtils.EQUAL_MARK + this.f40815f.get(str7), str7 + UrlUtils.EQUAL_MARK + this.f40814e.get(str7), false, 4, null);
        }
    }

    public final void r(Context context) {
        x(this, context, null, 2, null);
    }

    public final void s(Context context, int i11, bg.c cVar) {
        t(context, null, i11, cVar);
    }

    public final void t(final Context context, final Fragment fragment, final int i11, final bg.c cVar) {
        LinkedList linkedList;
        List<bg.e> list;
        List<bg.g> list2;
        Function2 function2;
        Bundle extras;
        if (!RouteMapKt.i() || this.f40817h) {
            this.f40817h = true;
            TheRouterKt.d("Navigator::navigation", "add pending navigator " + o(), null, 4, null);
            linkedList = NavigatorKt.f40821a;
            linkedList.addLast(new g(this, new Function0<Unit>() { // from class: com.therouter.router.Navigator$navigation$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m856invoke();
                    return Unit.f67184a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m856invoke() {
                    Navigator.this.f40817h = false;
                    Navigator.this.t(context, fragment, i11, cVar);
                }
            }));
            return;
        }
        TheRouterKt.d("Navigator::navigation", "begin navigate " + o(), null, 4, null);
        if (context == null) {
            context = fragment != null ? fragment.getActivity() : null;
            if (context == null) {
                context = com.therouter.c.c();
            }
        }
        final Context context2 = context;
        if (cVar == null) {
            cVar = NavigatorKt.f40826f;
        }
        String o11 = o();
        list = NavigatorKt.f40824d;
        for (bg.e eVar : list) {
            if (eVar != null && eVar.c(o11)) {
                String b11 = eVar.b(o11);
                TheRouterKt.d("Navigator::navigation", o11 + " replace to " + ((Object) b11), null, 4, null);
                o11 = b11;
            }
        }
        RouteItem k11 = RouteMapKt.k(o11);
        ActionManager actionManager = ActionManager.f40832a;
        if (actionManager.d(this) && k11 == null) {
            actionManager.c(this, context2);
            return;
        }
        if (k11 != null && (extras = k11.getExtras()) != null) {
            extras.putAll(this.f40814e);
            Set<String> keySet = this.f40815f.keySet();
            Intrinsics.g(keySet, "<get-keys>(...)");
            for (String str : keySet) {
                if (!extras.containsKey(str)) {
                    extras.putString(str, (String) this.f40815f.get(str));
                }
            }
        }
        if (k11 != null) {
            TheRouterKt.d("Navigator::navigation", "match route " + k11, null, 4, null);
        }
        list2 = NavigatorKt.f40825e;
        for (bg.g gVar : list2) {
            if (gVar != null && gVar.b(k11) && (k11 = gVar.a(k11)) != null) {
                TheRouterKt.d("Navigator::navigation", "route replace to " + k11, null, 4, null);
            }
        }
        if (k11 == null) {
            cVar.d(this, i11);
            return;
        }
        String className = k11.getClassName();
        if (className == null) {
            className = "";
        }
        if (!c.b(className)) {
            TheRouterKt.d("Navigator::navigation", "NavigationCallback on found", null, 4, null);
            cVar.c(this);
            function2 = NavigatorKt.f40827g;
            final bg.c cVar2 = cVar;
            function2.invoke(k11, new Function1<RouteItem, Unit>() { // from class: com.therouter.router.Navigator$navigation$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((RouteItem) obj);
                    return Unit.f67184a;
                }

                public final void invoke(final RouteItem routeItem) {
                    Uri uri;
                    ClipData clipData;
                    ComponentName componentName;
                    Bundle bundle;
                    Bundle bundle2;
                    Bundle bundle3;
                    Bundle bundle4;
                    Bundle bundle5;
                    String str2;
                    String str3;
                    Intrinsics.h(routeItem, "routeItem");
                    Intent n11 = Navigator.this.n();
                    if (n11 == null) {
                        n11 = new Intent();
                    }
                    uri = Navigator.this.f40819j;
                    if (uri != null) {
                        n11.setData(uri);
                    }
                    clipData = Navigator.this.f40820k;
                    if (clipData != null) {
                        n11.setClipData(clipData);
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        str2 = Navigator.this.f40818i;
                        if (str2 != null) {
                            str3 = Navigator.this.f40818i;
                            n11.setIdentifier(str3);
                        }
                    }
                    Context context3 = context2;
                    if (context3 != null) {
                        componentName = new ComponentName(context3.getPackageName(), routeItem.getClassName());
                    } else {
                        Navigator navigator = Navigator.this;
                        if (TheRouter.m()) {
                            throw new RuntimeException("context is null, path is -> " + navigator.p());
                        }
                        TheRouterKt.d("Navigator::navigation", "context is null, path is -> " + navigator.p(), null, 4, null);
                        componentName = null;
                    }
                    n11.setComponent(componentName);
                    if (!(context2 instanceof Activity) && fragment == null) {
                        n11.addFlags(ASTNode.DEOP);
                    }
                    com.therouter.f fVar = com.therouter.f.f40783a;
                    String className2 = routeItem.getClassName();
                    final bg.c cVar3 = cVar2;
                    final Navigator navigator2 = Navigator.this;
                    fVar.a(className2, new Function1<Activity, Unit>() { // from class: com.therouter.router.Navigator$navigation$6.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Activity) obj);
                            return Unit.f67184a;
                        }

                        public final void invoke(Activity it) {
                            Intrinsics.h(it, "it");
                            if (Intrinsics.c(it.getClass().getName(), RouteItem.this.getClassName())) {
                                cVar3.a(navigator2, it);
                                if (TextUtils.isEmpty(RouteItem.this.getAction())) {
                                    return;
                                }
                                TheRouter.c(RouteItem.this.getAction()).H("therouter_object_navigator", navigator2).H("therouter_object_current_activity", it).i(it);
                            }
                        }
                    });
                    n11.putExtra("therouter_action", routeItem.getAction());
                    n11.putExtra("therouter_path", Navigator.this.p());
                    n11.putExtra("therouter_description", routeItem.getDescription());
                    Bundle extras2 = routeItem.getExtras();
                    Bundle bundle6 = extras2.getBundle("therouter_bundle");
                    if (bundle6 != null) {
                        extras2.remove("therouter_bundle");
                        n11.putExtra("therouter_bundle", bundle6);
                    }
                    n11.putExtras(extras2);
                    n11.addFlags(routeItem.getExtras().getInt("therouter_intent_flags"));
                    if (i11 == -1008600) {
                        if (fragment != null) {
                            TheRouterKt.d("Navigator::navigation", "fragment.startActivity " + routeItem.getClassName(), null, 4, null);
                            Fragment fragment2 = fragment;
                            bundle5 = Navigator.this.f40816g;
                            fragment2.startActivity(n11, bundle5);
                        } else {
                            TheRouterKt.d("Navigator::navigation", "startActivity " + routeItem.getClassName(), null, 4, null);
                            Context context4 = context2;
                            if (context4 != null) {
                                bundle4 = Navigator.this.f40816g;
                                context4.startActivity(n11, bundle4);
                            }
                        }
                    } else if (fragment != null) {
                        TheRouterKt.d("Navigator::navigation", "fragment.startActivityForResult " + routeItem.getClassName(), null, 4, null);
                        Fragment fragment3 = fragment;
                        int i12 = i11;
                        bundle3 = Navigator.this.f40816g;
                        fragment3.startActivityForResult(n11, i12, bundle3);
                    } else if (context2 instanceof Activity) {
                        TheRouterKt.d("Navigator::navigation", "startActivityForResult " + routeItem.getClassName(), null, 4, null);
                        Activity activity = (Activity) context2;
                        int i13 = i11;
                        bundle2 = Navigator.this.f40816g;
                        activity.startActivityForResult(n11, i13, bundle2);
                    } else {
                        if (TheRouter.m()) {
                            throw new RuntimeException("TheRouter::Navigator context is not Activity or Fragment");
                        }
                        Context context5 = context2;
                        if (context5 != null) {
                            bundle = Navigator.this.f40816g;
                            context5.startActivity(n11, bundle);
                        }
                    }
                    int i14 = routeItem.getExtras().getInt("therouter_intent_animation_in");
                    int i15 = routeItem.getExtras().getInt("therouter_intent_animation_out");
                    if (i14 != 0 || i15 != 0) {
                        if (context2 instanceof Activity) {
                            TheRouterKt.d("Navigator::navigation", "overridePendingTransition " + routeItem.getClassName(), null, 4, null);
                            ((Activity) context2).overridePendingTransition(routeItem.getExtras().getInt("therouter_intent_animation_in"), routeItem.getExtras().getInt("therouter_intent_animation_out"));
                        } else {
                            Fragment fragment4 = fragment;
                            if (fragment4 != null) {
                                FragmentActivity activity2 = fragment4.getActivity();
                                if (activity2 != null) {
                                    activity2.overridePendingTransition(routeItem.getExtras().getInt("therouter_intent_animation_in"), routeItem.getExtras().getInt("therouter_intent_animation_out"));
                                }
                            } else if (TheRouter.m()) {
                                throw new RuntimeException("TheRouter::Navigator context is not Activity, ignore animation");
                            }
                        }
                    }
                    HistoryRecorder.c(new com.therouter.history.b(Navigator.this.p()));
                }
            });
            cVar.b(this);
            return;
        }
        if (TheRouter.m()) {
            throw new RuntimeException("TheRouter::Navigator " + k11.getClassName() + " is Fragment");
        }
    }

    public final void u(Context context, bg.c cVar) {
        s(context, -1008600, cVar);
    }

    public final void v(Fragment fragment, int i11, bg.c cVar) {
        t(fragment != null ? fragment.getActivity() : null, fragment, i11, cVar);
    }

    public final Navigator z(String str, boolean z10) {
        this.f40814e.putBoolean(str, z10);
        return this;
    }
}
