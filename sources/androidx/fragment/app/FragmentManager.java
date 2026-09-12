package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.w;
import androidx.view.C1013c;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.x0;
import androidx.view.y0;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class FragmentManager {
    private static boolean S;
    private androidx.activity.result.b D;
    private androidx.activity.result.b E;
    private androidx.activity.result.b F;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList M;
    private ArrayList N;
    private ArrayList O;
    private r P;
    private FragmentStrictMode.b Q;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9390b;

    /* renamed from: d, reason: collision with root package name */
    ArrayList f9392d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f9393e;

    /* renamed from: g, reason: collision with root package name */
    private OnBackPressedDispatcher f9395g;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList f9401m;

    /* renamed from: v, reason: collision with root package name */
    private androidx.fragment.app.i f9410v;

    /* renamed from: w, reason: collision with root package name */
    private androidx.fragment.app.f f9411w;

    /* renamed from: x, reason: collision with root package name */
    private Fragment f9412x;

    /* renamed from: y, reason: collision with root package name */
    Fragment f9413y;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f9389a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final v f9391c = new v();

    /* renamed from: f, reason: collision with root package name */
    private final androidx.fragment.app.j f9394f = new androidx.fragment.app.j(this);

    /* renamed from: h, reason: collision with root package name */
    private final androidx.activity.u f9396h = new b(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f9397i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map f9398j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map f9399k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    private final Map f9400l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    private final androidx.fragment.app.k f9402n = new androidx.fragment.app.k(this);

    /* renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList f9403o = new CopyOnWriteArrayList();

    /* renamed from: p, reason: collision with root package name */
    private final androidx.core.util.a f9404p = new androidx.core.util.a() { // from class: androidx.fragment.app.l
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            FragmentManager.this.V0((Configuration) obj);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private final androidx.core.util.a f9405q = new androidx.core.util.a() { // from class: androidx.fragment.app.m
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            FragmentManager.this.W0((Integer) obj);
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private final androidx.core.util.a f9406r = new androidx.core.util.a() { // from class: androidx.fragment.app.n
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            FragmentManager.this.X0((androidx.core.app.m) obj);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private final androidx.core.util.a f9407s = new androidx.core.util.a() { // from class: androidx.fragment.app.o
        @Override // androidx.core.util.a
        public final void accept(Object obj) {
            FragmentManager.this.Y0((androidx.core.app.x) obj);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private final MenuProvider f9408t = new c();

    /* renamed from: u, reason: collision with root package name */
    int f9409u = -1;

    /* renamed from: z, reason: collision with root package name */
    private androidx.fragment.app.h f9414z = null;
    private androidx.fragment.app.h A = new d();
    private b0 B = null;
    private b0 C = new e();
    ArrayDeque G = new ArrayDeque();
    private Runnable R = new Runnable() { // from class: androidx.fragment.app.FragmentManager.5
        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.c0(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f9415a;

        /* renamed from: b, reason: collision with root package name */
        int f9416b;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i11) {
                return new LaunchedFragmentInfo[i11];
            }
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f9415a = parcel.readString();
            this.f9416b = parcel.readInt();
        }

        LaunchedFragmentInfo(String str, int i11) {
            this.f9415a = str;
            this.f9416b = i11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.f9415a);
            parcel.writeInt(this.f9416b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.result.a {
        a() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                iArr[i11] = ((Boolean) arrayList.get(i11)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfo.f9415a;
            int i12 = launchedFragmentInfo.f9416b;
            Fragment i13 = FragmentManager.this.f9391c.i(str);
            if (i13 != null) {
                i13.onRequestPermissionsResult(i12, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.activity.u {
        b(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            FragmentManager.this.I0();
        }
    }

    /* loaded from: classes.dex */
    class c implements MenuProvider {
        c() {
        }

        @Override // androidx.core.view.MenuProvider
        public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.E(menu, menuInflater);
        }

        @Override // androidx.core.view.MenuProvider
        public void onMenuClosed(Menu menu) {
            FragmentManager.this.M(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public boolean onMenuItemSelected(MenuItem menuItem) {
            return FragmentManager.this.L(menuItem);
        }

        @Override // androidx.core.view.MenuProvider
        public void onPrepareMenu(Menu menu) {
            FragmentManager.this.Q(menu);
        }
    }

    /* loaded from: classes.dex */
    class d extends androidx.fragment.app.h {
        d() {
        }

        @Override // androidx.fragment.app.h
        public Fragment instantiate(ClassLoader classLoader, String str) {
            return FragmentManager.this.z0().b(FragmentManager.this.z0().f(), str, null);
        }
    }

    /* loaded from: classes.dex */
    class e implements b0 {
        e() {
        }

        @Override // androidx.fragment.app.b0
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    }

    /* loaded from: classes.dex */
    class f implements androidx.view.r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9422a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f9423b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Lifecycle f9424c;

        f(String str, t tVar, Lifecycle lifecycle) {
            this.f9422a = str;
            this.f9423b = tVar;
            this.f9424c = lifecycle;
        }

        @Override // androidx.view.r
        public void onStateChanged(androidx.view.u uVar, Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f9399k.get(this.f9422a)) != null) {
                this.f9423b.a(this.f9422a, bundle);
                FragmentManager.this.u(this.f9422a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f9424c.d(this);
                FragmentManager.this.f9400l.remove(this.f9422a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f9426a;

        g(Fragment fragment) {
            this.f9426a = fragment;
        }

        @Override // androidx.fragment.app.s
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f9426a.onAttachFragment(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements androidx.activity.result.a {
        h() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfo.f9415a;
            int i11 = launchedFragmentInfo.f9416b;
            Fragment i12 = FragmentManager.this.f9391c.i(str);
            if (i12 != null) {
                i12.onActivityResult(i11, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements androidx.activity.result.a {
        i() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfo == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfo.f9415a;
            int i11 = launchedFragmentInfo.f9416b;
            Fragment i12 = FragmentManager.this.f9391c.i(str);
            if (i12 != null) {
                i12.onActivityResult(i11, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class j extends f.a {
        j() {
        }

        @Override // f.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (fillInIntent != null && (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.getIntentSender()).b(null).c(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // f.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i11, Intent intent) {
            return new ActivityResult(i11, intent);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    /* loaded from: classes.dex */
    private static class l implements t {

        /* renamed from: a, reason: collision with root package name */
        private final Lifecycle f9430a;

        /* renamed from: b, reason: collision with root package name */
        private final t f9431b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.view.r f9432c;

        l(Lifecycle lifecycle, t tVar, androidx.view.r rVar) {
            this.f9430a = lifecycle;
            this.f9431b = tVar;
            this.f9432c = rVar;
        }

        @Override // androidx.fragment.app.t
        public void a(String str, Bundle bundle) {
            this.f9431b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f9430a.b().isAtLeast(state);
        }

        public void c() {
            this.f9430a.d(this.f9432c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface m {
        boolean a(ArrayList arrayList, ArrayList arrayList2);
    }

    /* loaded from: classes.dex */
    private class n implements m {

        /* renamed from: a, reason: collision with root package name */
        final String f9433a;

        /* renamed from: b, reason: collision with root package name */
        final int f9434b;

        /* renamed from: c, reason: collision with root package name */
        final int f9435c;

        n(String str, int i11, int i12) {
            this.f9433a = str;
            this.f9434b = i11;
            this.f9435c = i12;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.f9413y;
            if (fragment == null || this.f9434b >= 0 || this.f9433a != null || !fragment.getChildFragmentManager().j1()) {
                return FragmentManager.this.n1(arrayList, arrayList2, this.f9433a, this.f9434b, this.f9435c);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    private class o implements m {

        /* renamed from: a, reason: collision with root package name */
        private final String f9437a;

        o(String str) {
            this.f9437a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return FragmentManager.this.v1(arrayList, arrayList2, this.f9437a);
        }
    }

    /* loaded from: classes.dex */
    private class p implements m {

        /* renamed from: a, reason: collision with root package name */
        private final String f9439a;

        p(String str) {
            this.f9439a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(ArrayList arrayList, ArrayList arrayList2) {
            return FragmentManager.this.A1(arrayList, arrayList2, this.f9439a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Fragment G0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    private void J1(Fragment fragment) {
        ViewGroup v02 = v0(fragment);
        if (v02 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        if (v02.getTag(R$id.visible_removing_fragment_view_tag) == null) {
            v02.setTag(R$id.visible_removing_fragment_view_tag, fragment);
        }
        ((Fragment) v02.getTag(R$id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
    }

    private void L1() {
        Iterator it = this.f9391c.k().iterator();
        while (it.hasNext()) {
            f1((u) it.next());
        }
    }

    public static boolean M0(int i11) {
        return S || Log.isLoggable("FragmentManager", i11);
    }

    private void M1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new a0("FragmentManager"));
        androidx.fragment.app.i iVar = this.f9410v;
        if (iVar != null) {
            try {
                iVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e11) {
                Log.e("FragmentManager", "Failed dumping state", e11);
                throw runtimeException;
            }
        }
        try {
            Y("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e12) {
            Log.e("FragmentManager", "Failed dumping state", e12);
            throw runtimeException;
        }
    }

    private void N(Fragment fragment) {
        if (fragment == null || !fragment.equals(h0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    private boolean N0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.q();
    }

    private boolean O0() {
        Fragment fragment = this.f9412x;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f9412x.getParentFragmentManager().O0();
    }

    private void O1() {
        synchronized (this.f9389a) {
            try {
                if (this.f9389a.isEmpty()) {
                    this.f9396h.setEnabled(r0() > 0 && R0(this.f9412x));
                } else {
                    this.f9396h.setEnabled(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void U(int i11) {
        try {
            this.f9390b = true;
            this.f9391c.d(i11);
            c1(i11, false);
            Iterator it = v().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).j();
            }
            this.f9390b = false;
            c0(true);
        } catch (Throwable th2) {
            this.f9390b = false;
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(Configuration configuration) {
        if (O0()) {
            B(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(Integer num) {
        if (O0() && num.intValue() == 80) {
            H(false);
        }
    }

    private void X() {
        if (this.L) {
            this.L = false;
            L1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(androidx.core.app.m mVar) {
        if (O0()) {
            I(mVar.a(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(androidx.core.app.x xVar) {
        if (O0()) {
            P(xVar.a(), false);
        }
    }

    private void Z() {
        Iterator it = v().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).j();
        }
    }

    private void b0(boolean z10) {
        if (this.f9390b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f9410v == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f9410v.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            r();
        }
        if (this.M == null) {
            this.M = new ArrayList();
            this.N = new ArrayList();
        }
    }

    private static void e0(ArrayList arrayList, ArrayList arrayList2, int i11, int i12) {
        while (i11 < i12) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i11);
            if (((Boolean) arrayList2.get(i11)).booleanValue()) {
                aVar.z(-1);
                aVar.F();
            } else {
                aVar.z(1);
                aVar.E();
            }
            i11++;
        }
    }

    private void f0(ArrayList arrayList, ArrayList arrayList2, int i11, int i12) {
        boolean z10 = ((androidx.fragment.app.a) arrayList.get(i11)).f9575r;
        ArrayList arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.f9391c.o());
        Fragment D0 = D0();
        boolean z11 = false;
        for (int i13 = i11; i13 < i12; i13++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i13);
            D0 = !((Boolean) arrayList2.get(i13)).booleanValue() ? aVar.G(this.O, D0) : aVar.J(this.O, D0);
            z11 = z11 || aVar.f9566i;
        }
        this.O.clear();
        if (!z10 && this.f9409u >= 1) {
            for (int i14 = i11; i14 < i12; i14++) {
                Iterator it = ((androidx.fragment.app.a) arrayList.get(i14)).f9560c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((w.a) it.next()).f9578b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f9391c.r(x(fragment));
                    }
                }
            }
        }
        e0(arrayList, arrayList2, i11, i12);
        boolean booleanValue = ((Boolean) arrayList2.get(i12 - 1)).booleanValue();
        for (int i15 = i11; i15 < i12; i15++) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i15);
            if (booleanValue) {
                for (int size = aVar2.f9560c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = ((w.a) aVar2.f9560c.get(size)).f9578b;
                    if (fragment2 != null) {
                        x(fragment2).m();
                    }
                }
            } else {
                Iterator it2 = aVar2.f9560c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = ((w.a) it2.next()).f9578b;
                    if (fragment3 != null) {
                        x(fragment3).m();
                    }
                }
            }
        }
        c1(this.f9409u, true);
        for (SpecialEffectsController specialEffectsController : w(arrayList, i11, i12)) {
            specialEffectsController.r(booleanValue);
            specialEffectsController.p();
            specialEffectsController.g();
        }
        while (i11 < i12) {
            androidx.fragment.app.a aVar3 = (androidx.fragment.app.a) arrayList.get(i11);
            if (((Boolean) arrayList2.get(i11)).booleanValue() && aVar3.f9506v >= 0) {
                aVar3.f9506v = -1;
            }
            aVar3.I();
            i11++;
        }
        if (z11) {
            t1();
        }
    }

    private int i0(String str, int i11, boolean z10) {
        ArrayList arrayList = this.f9392d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i11 < 0) {
            if (z10) {
                return 0;
            }
            return this.f9392d.size() - 1;
        }
        int size = this.f9392d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f9392d.get(size);
            if ((str != null && str.equals(aVar.H())) || (i11 >= 0 && i11 == aVar.f9506v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f9392d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.f9392d.get(size - 1);
            if ((str == null || !str.equals(aVar2.H())) && (i11 < 0 || i11 != aVar2.f9506v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FragmentManager m0(View view) {
        FragmentActivity fragmentActivity;
        Fragment n02 = n0(view);
        if (n02 != null) {
            if (n02.isAdded()) {
                return n02.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + n02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private boolean m1(String str, int i11, int i12) {
        c0(false);
        b0(true);
        Fragment fragment = this.f9413y;
        if (fragment != null && i11 < 0 && str == null && fragment.getChildFragmentManager().j1()) {
            return true;
        }
        boolean n12 = n1(this.M, this.N, str, i11, i12);
        if (n12) {
            this.f9390b = true;
            try {
                r1(this.M, this.N);
            } finally {
                s();
            }
        }
        O1();
        X();
        this.f9391c.b();
        return n12;
    }

    private static Fragment n0(View view) {
        while (view != null) {
            Fragment G0 = G0(view);
            if (G0 != null) {
                return G0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void o0() {
        Iterator it = v().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).k();
        }
    }

    private boolean p0(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f9389a) {
            if (this.f9389a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f9389a.size();
                boolean z10 = false;
                for (int i11 = 0; i11 < size; i11++) {
                    z10 |= ((m) this.f9389a.get(i11)).a(arrayList, arrayList2);
                }
                return z10;
            } finally {
                this.f9389a.clear();
                this.f9410v.g().removeCallbacks(this.R);
            }
        }
    }

    private void r() {
        if (T0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void r1(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (i11 < size) {
            if (!((androidx.fragment.app.a) arrayList.get(i11)).f9575r) {
                if (i12 != i11) {
                    f0(arrayList, arrayList2, i12, i11);
                }
                i12 = i11 + 1;
                if (((Boolean) arrayList2.get(i11)).booleanValue()) {
                    while (i12 < size && ((Boolean) arrayList2.get(i12)).booleanValue() && !((androidx.fragment.app.a) arrayList.get(i12)).f9575r) {
                        i12++;
                    }
                }
                f0(arrayList, arrayList2, i11, i12);
                i11 = i12 - 1;
            }
            i11++;
        }
        if (i12 != size) {
            f0(arrayList, arrayList2, i12, size);
        }
    }

    private void s() {
        this.f9390b = false;
        this.N.clear();
        this.M.clear();
    }

    private r s0(Fragment fragment) {
        return this.P.g(fragment);
    }

    private void t() {
        androidx.fragment.app.i iVar = this.f9410v;
        if (iVar instanceof y0 ? this.f9391c.p().k() : iVar.f() instanceof Activity ? !((Activity) this.f9410v.f()).isChangingConfigurations() : true) {
            Iterator it = this.f9398j.values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((BackStackState) it.next()).f9310a.iterator();
                while (it2.hasNext()) {
                    this.f9391c.p().d((String) it2.next());
                }
            }
        }
    }

    private void t1() {
        ArrayList arrayList = this.f9401m;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.c.a(this.f9401m.get(0));
        throw null;
    }

    private Set v() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f9391c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((u) it.next()).k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, E0()));
            }
        }
        return hashSet;
    }

    private ViewGroup v0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f9411w.d()) {
            View c11 = this.f9411w.c(fragment.mContainerId);
            if (c11 instanceof ViewGroup) {
                return (ViewGroup) c11;
            }
        }
        return null;
    }

    private Set w(ArrayList arrayList, int i11, int i12) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i11 < i12) {
            Iterator it = ((androidx.fragment.app.a) arrayList.get(i11)).f9560c.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((w.a) it.next()).f9578b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i11++;
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x1(int i11) {
        int i12 = 4097;
        if (i11 == 4097) {
            return InputDeviceCompat.SOURCE_MOUSE;
        }
        if (i11 != 8194) {
            i12 = 8197;
            if (i11 == 8197) {
                return TaErrorCode.CODE_AD_UNIT_CONFIG_IS_EMPTY;
            }
            if (i11 == 4099) {
                return 4099;
            }
            if (i11 != 4100) {
                return 0;
            }
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 A0() {
        return this.f9394f;
    }

    boolean A1(ArrayList arrayList, ArrayList arrayList2, String str) {
        int i11;
        int i02 = i0(str, -1, true);
        if (i02 < 0) {
            return false;
        }
        for (int i12 = i02; i12 < this.f9392d.size(); i12++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f9392d.get(i12);
            if (!aVar.f9575r) {
                M1(new IllegalArgumentException("saveBackStack(\"" + str + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + aVar + " that did not use setReorderingAllowed(true)."));
            }
        }
        HashSet hashSet = new HashSet();
        for (int i13 = i02; i13 < this.f9392d.size(); i13++) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) this.f9392d.get(i13);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Iterator it = aVar2.f9560c.iterator();
            while (it.hasNext()) {
                w.a aVar3 = (w.a) it.next();
                Fragment fragment = aVar3.f9578b;
                if (fragment != null) {
                    if (!aVar3.f9579c || (i11 = aVar3.f9577a) == 1 || i11 == 2 || i11 == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i14 = aVar3.f9577a;
                    if (i14 == 1 || i14 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str);
                sb2.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                sb2.append(hashSet2.size() == 1 ? " " + hashSet2.iterator().next() : "s " + hashSet2);
                sb2.append(" in ");
                sb2.append(aVar2);
                sb2.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                M1(new IllegalArgumentException(sb2.toString()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.mRetainInstance) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("saveBackStack(\"");
                sb3.append(str);
                sb3.append("\") must not contain retained fragments. Found ");
                sb3.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb3.append("fragment ");
                sb3.append(fragment2);
                M1(new IllegalArgumentException(sb3.toString()));
            }
            for (Fragment fragment3 : fragment2.mChildFragmentManager.q0()) {
                if (fragment3 != null) {
                    arrayDeque.addLast(fragment3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((Fragment) it2.next()).mWho);
        }
        ArrayList arrayList4 = new ArrayList(this.f9392d.size() - i02);
        for (int i15 = i02; i15 < this.f9392d.size(); i15++) {
            arrayList4.add(null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = this.f9392d.size() - 1; size >= i02; size--) {
            androidx.fragment.app.a aVar4 = (androidx.fragment.app.a) this.f9392d.remove(size);
            androidx.fragment.app.a aVar5 = new androidx.fragment.app.a(aVar4);
            aVar5.A();
            arrayList4.set(size - i02, new BackStackRecordState(aVar5));
            aVar4.f9507w = true;
            arrayList.add(aVar4);
            arrayList2.add(Boolean.TRUE);
        }
        this.f9398j.put(str, backStackState);
        return true;
    }

    void B(Configuration configuration, boolean z10) {
        if (z10 && (this.f9410v instanceof androidx.core.content.d)) {
            M1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z10) {
                    fragment.mChildFragmentManager.B(configuration, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.fragment.app.k B0() {
        return this.f9402n;
    }

    public Fragment.SavedState B1(Fragment fragment) {
        u n11 = this.f9391c.n(fragment.mWho);
        if (n11 == null || !n11.k().equals(fragment)) {
            M1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n11.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(MenuItem menuItem) {
        if (this.f9409u < 1) {
            return false;
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment C0() {
        return this.f9412x;
    }

    void C1() {
        synchronized (this.f9389a) {
            try {
                if (this.f9389a.size() == 1) {
                    this.f9410v.g().removeCallbacks(this.R);
                    this.f9410v.g().post(this.R);
                    O1();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(1);
    }

    public Fragment D0() {
        return this.f9413y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D1(Fragment fragment, boolean z10) {
        ViewGroup v02 = v0(fragment);
        if (v02 == null || !(v02 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) v02).setDrawDisappearingViewsLast(!z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E(Menu menu, MenuInflater menuInflater) {
        if (this.f9409u < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null && Q0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f9393e != null) {
            for (int i11 = 0; i11 < this.f9393e.size(); i11++) {
                Fragment fragment2 = (Fragment) this.f9393e.get(i11);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f9393e = arrayList;
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0 E0() {
        b0 b0Var = this.B;
        if (b0Var != null) {
            return b0Var;
        }
        Fragment fragment = this.f9412x;
        return fragment != null ? fragment.mFragmentManager.E0() : this.C;
    }

    public void E1(androidx.fragment.app.h hVar) {
        this.f9414z = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        this.K = true;
        c0(true);
        Z();
        t();
        U(-1);
        Object obj = this.f9410v;
        if (obj instanceof androidx.core.content.e) {
            ((androidx.core.content.e) obj).removeOnTrimMemoryListener(this.f9405q);
        }
        Object obj2 = this.f9410v;
        if (obj2 instanceof androidx.core.content.d) {
            ((androidx.core.content.d) obj2).removeOnConfigurationChangedListener(this.f9404p);
        }
        Object obj3 = this.f9410v;
        if (obj3 instanceof androidx.core.app.u) {
            ((androidx.core.app.u) obj3).removeOnMultiWindowModeChangedListener(this.f9406r);
        }
        Object obj4 = this.f9410v;
        if (obj4 instanceof androidx.core.app.v) {
            ((androidx.core.app.v) obj4).removeOnPictureInPictureModeChangedListener(this.f9407s);
        }
        Object obj5 = this.f9410v;
        if (obj5 instanceof MenuHost) {
            ((MenuHost) obj5).removeMenuProvider(this.f9408t);
        }
        this.f9410v = null;
        this.f9411w = null;
        this.f9412x = null;
        if (this.f9395g != null) {
            this.f9396h.remove();
            this.f9395g = null;
        }
        androidx.activity.result.b bVar = this.D;
        if (bVar != null) {
            bVar.c();
            this.E.c();
            this.F.c();
        }
    }

    public FragmentStrictMode.b F0() {
        return this.Q;
    }

    public final void F1(String str, Bundle bundle) {
        l lVar = (l) this.f9400l.get(str);
        if (lVar == null || !lVar.b(Lifecycle.State.STARTED)) {
            this.f9399k.put(str, bundle);
        } else {
            lVar.a(str, bundle);
        }
        if (M0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        U(1);
    }

    public final void G1(String str, androidx.view.u uVar, t tVar) {
        Lifecycle lifecycle = uVar.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        f fVar = new f(str, tVar, lifecycle);
        lifecycle.a(fVar);
        l lVar = (l) this.f9400l.put(str, new l(lifecycle, tVar, fVar));
        if (lVar != null) {
            lVar.c();
        }
        if (M0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + tVar);
        }
    }

    void H(boolean z10) {
        if (z10 && (this.f9410v instanceof androidx.core.content.e)) {
            M1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z10) {
                    fragment.mChildFragmentManager.H(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0 H0(Fragment fragment) {
        return this.P.j(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void I(boolean z10, boolean z11) {
        if (z11 && (this.f9410v instanceof androidx.core.app.u)) {
            M1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z10);
                if (z11) {
                    fragment.mChildFragmentManager.I(z10, true);
                }
            }
        }
    }

    void I0() {
        c0(true);
        if (this.f9396h.isEnabled()) {
            j1();
        } else {
            this.f9395g.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I1(Fragment fragment) {
        if (fragment == null || (fragment.equals(h0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f9413y;
            this.f9413y = fragment;
            N(fragment2);
            N(this.f9413y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(Fragment fragment) {
        Iterator it = this.f9403o.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(this, fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J0(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        J1(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        for (Fragment fragment : this.f9391c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.K();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K0(Fragment fragment) {
        if (fragment.mAdded && N0(fragment)) {
            this.H = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K1(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L(MenuItem menuItem) {
        if (this.f9409u < 1) {
            return false;
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean L0() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(Menu menu) {
        if (this.f9409u < 1) {
            return;
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void N1(k kVar) {
        this.f9402n.p(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        U(5);
    }

    void P(boolean z10, boolean z11) {
        if (z11 && (this.f9410v instanceof androidx.core.app.v)) {
            M1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z10);
                if (z11) {
                    fragment.mChildFragmentManager.P(z10, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean P0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q(Menu menu) {
        boolean z10 = false;
        if (this.f9409u < 1) {
            return false;
        }
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null && Q0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Q0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        O1();
        N(this.f9413y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean R0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.D0()) && R0(fragmentManager.f9412x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean S0(int i11) {
        return this.f9409u >= i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(5);
    }

    public boolean T0() {
        return this.I || this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        this.J = true;
        this.P.m(true);
        U(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W() {
        U(2);
    }

    public void Y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f9391c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList arrayList = this.f9393e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i11 = 0; i11 < size2; i11++) {
                Fragment fragment = (Fragment) this.f9393e.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList arrayList2 = this.f9392d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i12 = 0; i12 < size; i12++) {
                androidx.fragment.app.a aVar = (androidx.fragment.app.a) this.f9392d.get(i12);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.C(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f9397i.get());
        synchronized (this.f9389a) {
            try {
                int size3 = this.f9389a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i13 = 0; i13 < size3; i13++) {
                        m mVar = (m) this.f9389a.get(i13);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i13);
                        printWriter.print(": ");
                        printWriter.println(mVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f9410v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f9411w);
        if (this.f9412x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f9412x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f9409u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z0(Fragment fragment, String[] strArr, int i11) {
        if (this.F == null) {
            this.f9410v.k(fragment, strArr, i11);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
        this.F.a(strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a0(m mVar, boolean z10) {
        if (!z10) {
            if (this.f9410v == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            r();
        }
        synchronized (this.f9389a) {
            try {
                if (this.f9410v == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f9389a.add(mVar);
                    C1();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1(Fragment fragment, Intent intent, int i11, Bundle bundle) {
        if (this.D == null) {
            this.f9410v.m(fragment, intent, i11, bundle);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.D.a(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1(Fragment fragment, IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) {
        Intent intent2;
        if (this.E == null) {
            this.f9410v.n(fragment, intentSender, i11, intent, i12, i13, i14, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (M0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest a11 = new IntentSenderRequest.a(intentSender).b(intent2).c(i13, i12).a();
        this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i11));
        if (M0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.E.a(a11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c0(boolean z10) {
        b0(z10);
        boolean z11 = false;
        while (p0(this.M, this.N)) {
            z11 = true;
            this.f9390b = true;
            try {
                r1(this.M, this.N);
            } finally {
                s();
            }
        }
        O1();
        X();
        this.f9391c.b();
        return z11;
    }

    void c1(int i11, boolean z10) {
        androidx.fragment.app.i iVar;
        if (this.f9410v == null && i11 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i11 != this.f9409u) {
            this.f9409u = i11;
            this.f9391c.t();
            L1();
            if (this.H && (iVar = this.f9410v) != null && this.f9409u == 7) {
                iVar.o();
                this.H = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(m mVar, boolean z10) {
        if (z10 && (this.f9410v == null || this.K)) {
            return;
        }
        b0(z10);
        if (mVar.a(this.M, this.N)) {
            this.f9390b = true;
            try {
                r1(this.M, this.N);
            } finally {
                s();
            }
        }
        O1();
        X();
        this.f9391c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d1() {
        if (this.f9410v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.m(false);
        for (Fragment fragment : this.f9391c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e1(FragmentContainerView fragmentContainerView) {
        View view;
        for (u uVar : this.f9391c.k()) {
            Fragment k11 = uVar.k();
            if (k11.mContainerId == fragmentContainerView.getId() && (view = k11.mView) != null && view.getParent() == null) {
                k11.mContainer = fragmentContainerView;
                uVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f1(u uVar) {
        Fragment k11 = uVar.k();
        if (k11.mDeferStart) {
            if (this.f9390b) {
                this.L = true;
            } else {
                k11.mDeferStart = false;
                uVar.m();
            }
        }
    }

    public boolean g0() {
        boolean c02 = c0(true);
        o0();
        return c02;
    }

    public void g1() {
        a0(new n(null, -1, 0), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h0(String str) {
        return this.f9391c.f(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h1(int i11, int i12, boolean z10) {
        if (i11 >= 0) {
            a0(new n(null, i11, i12), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(androidx.fragment.app.a aVar) {
        if (this.f9392d == null) {
            this.f9392d = new ArrayList();
        }
        this.f9392d.add(aVar);
    }

    public void i1(String str, int i11) {
        a0(new n(str, -1, i11), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (M0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        u x10 = x(fragment);
        fragment.mFragmentManager = this;
        this.f9391c.r(x10);
        if (!fragment.mDetached) {
            this.f9391c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (N0(fragment)) {
                this.H = true;
            }
        }
        return x10;
    }

    public Fragment j0(int i11) {
        return this.f9391c.g(i11);
    }

    public boolean j1() {
        return m1(null, -1, 0);
    }

    public void k(s sVar) {
        this.f9403o.add(sVar);
    }

    public Fragment k0(String str) {
        return this.f9391c.h(str);
    }

    public boolean k1(int i11, int i12) {
        if (i11 >= 0) {
            return m1(null, i11, i12);
        }
        throw new IllegalArgumentException("Bad id: " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment) {
        this.P.b(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment l0(String str) {
        return this.f9391c.i(str);
    }

    public boolean l1(String str, int i11) {
        return m1(str, -1, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f9397i.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void n(androidx.fragment.app.i iVar, androidx.fragment.app.f fVar, Fragment fragment) {
        String str;
        if (this.f9410v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f9410v = iVar;
        this.f9411w = fVar;
        this.f9412x = fragment;
        if (fragment != null) {
            k(new g(fragment));
        } else if (iVar instanceof s) {
            k((s) iVar);
        }
        if (this.f9412x != null) {
            O1();
        }
        if (iVar instanceof androidx.activity.x) {
            androidx.activity.x xVar = (androidx.activity.x) iVar;
            OnBackPressedDispatcher onBackPressedDispatcher = xVar.getOnBackPressedDispatcher();
            this.f9395g = onBackPressedDispatcher;
            androidx.view.u uVar = xVar;
            if (fragment != null) {
                uVar = fragment;
            }
            onBackPressedDispatcher.i(uVar, this.f9396h);
        }
        if (fragment != null) {
            this.P = fragment.mFragmentManager.s0(fragment);
        } else if (iVar instanceof y0) {
            this.P = r.h(((y0) iVar).getViewModelStore());
        } else {
            this.P = new r(false);
        }
        this.P.m(T0());
        this.f9391c.A(this.P);
        Object obj = this.f9410v;
        if ((obj instanceof InterfaceC1015e) && fragment == null) {
            C1013c savedStateRegistry = ((InterfaceC1015e) obj).getSavedStateRegistry();
            savedStateRegistry.h("android:support:fragments", new C1013c.InterfaceC0130c() { // from class: androidx.fragment.app.p
                @Override // androidx.view.C1013c.InterfaceC0130c
                public final Bundle saveState() {
                    Bundle U0;
                    U0 = FragmentManager.this.U0();
                    return U0;
                }
            });
            Bundle b11 = savedStateRegistry.b("android:support:fragments");
            if (b11 != null) {
                w1(b11);
            }
        }
        Object obj2 = this.f9410v;
        if (obj2 instanceof androidx.activity.result.d) {
            ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.d) obj2).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.D = activityResultRegistry.m(str2 + "StartActivityForResult", new f.j(), new h());
            this.E = activityResultRegistry.m(str2 + "StartIntentSenderForResult", new j(), new i());
            this.F = activityResultRegistry.m(str2 + "RequestPermissions", new f.h(), new a());
        }
        Object obj3 = this.f9410v;
        if (obj3 instanceof androidx.core.content.d) {
            ((androidx.core.content.d) obj3).addOnConfigurationChangedListener(this.f9404p);
        }
        Object obj4 = this.f9410v;
        if (obj4 instanceof androidx.core.content.e) {
            ((androidx.core.content.e) obj4).addOnTrimMemoryListener(this.f9405q);
        }
        Object obj5 = this.f9410v;
        if (obj5 instanceof androidx.core.app.u) {
            ((androidx.core.app.u) obj5).addOnMultiWindowModeChangedListener(this.f9406r);
        }
        Object obj6 = this.f9410v;
        if (obj6 instanceof androidx.core.app.v) {
            ((androidx.core.app.v) obj6).addOnPictureInPictureModeChangedListener(this.f9407s);
        }
        Object obj7 = this.f9410v;
        if ((obj7 instanceof MenuHost) && fragment == null) {
            ((MenuHost) obj7).addMenuProvider(this.f9408t);
        }
    }

    boolean n1(ArrayList arrayList, ArrayList arrayList2, String str, int i11, int i12) {
        int i02 = i0(str, i11, (i12 & 1) != 0);
        if (i02 < 0) {
            return false;
        }
        for (int size = this.f9392d.size() - 1; size >= i02; size--) {
            arrayList.add((androidx.fragment.app.a) this.f9392d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f9391c.a(fragment);
            if (M0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (N0(fragment)) {
                this.H = true;
            }
        }
    }

    public void o1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            M1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public w p() {
        return new androidx.fragment.app.a(this);
    }

    public void p1(k kVar, boolean z10) {
        this.f9402n.o(kVar, z10);
    }

    boolean q() {
        boolean z10 = false;
        for (Fragment fragment : this.f9391c.l()) {
            if (fragment != null) {
                z10 = N0(fragment);
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    List q0() {
        return this.f9391c.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q1(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && isInBackStack) {
            return;
        }
        this.f9391c.u(fragment);
        if (N0(fragment)) {
            this.H = true;
        }
        fragment.mRemoving = true;
        J1(fragment);
    }

    public int r0() {
        ArrayList arrayList = this.f9392d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s1(Fragment fragment) {
        this.P.l(fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.fragment.app.f t0() {
        return this.f9411w;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f9412x;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f9412x)));
            sb2.append("}");
        } else {
            androidx.fragment.app.i iVar = this.f9410v;
            if (iVar != null) {
                sb2.append(iVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f9410v)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u(String str) {
        this.f9399k.remove(str);
        if (M0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public Fragment u0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment h02 = h0(string);
        if (h02 == null) {
            M1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return h02;
    }

    public void u1(String str) {
        a0(new o(str), false);
    }

    boolean v1(ArrayList arrayList, ArrayList arrayList2, String str) {
        BackStackState backStackState = (BackStackState) this.f9398j.remove(str);
        if (backStackState == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) it.next();
            if (aVar.f9507w) {
                Iterator it2 = aVar.f9560c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = ((w.a) it2.next()).f9578b;
                    if (fragment != null) {
                        hashMap.put(fragment.mWho, fragment);
                    }
                }
            }
        }
        Iterator it3 = backStackState.a(this, hashMap).iterator();
        while (true) {
            boolean z10 = false;
            while (it3.hasNext()) {
                if (((androidx.fragment.app.a) it3.next()).a(arrayList, arrayList2) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public androidx.fragment.app.h w0() {
        androidx.fragment.app.h hVar = this.f9414z;
        if (hVar != null) {
            return hVar;
        }
        Fragment fragment = this.f9412x;
        return fragment != null ? fragment.mFragmentManager.w0() : this.A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w1(Parcelable parcelable) {
        u uVar;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f9410v.f().getClassLoader());
                this.f9399k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f9410v.f().getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        this.f9391c.x(arrayList);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.f9391c.v();
        Iterator it = fragmentManagerState.f9441a.iterator();
        while (it.hasNext()) {
            FragmentState B = this.f9391c.B((String) it.next(), null);
            if (B != null) {
                Fragment f11 = this.P.f(B.f9450b);
                if (f11 != null) {
                    if (M0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + f11);
                    }
                    uVar = new u(this.f9402n, this.f9391c, f11, B);
                } else {
                    uVar = new u(this.f9402n, this.f9391c, this.f9410v.f().getClassLoader(), w0(), B);
                }
                Fragment k11 = uVar.k();
                k11.mFragmentManager = this;
                if (M0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k11.mWho + "): " + k11);
                }
                uVar.o(this.f9410v.f().getClassLoader());
                this.f9391c.r(uVar);
                uVar.u(this.f9409u);
            }
        }
        for (Fragment fragment : this.P.i()) {
            if (!this.f9391c.c(fragment.mWho)) {
                if (M0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f9441a);
                }
                this.P.l(fragment);
                fragment.mFragmentManager = this;
                u uVar2 = new u(this.f9402n, this.f9391c, fragment);
                uVar2.u(1);
                uVar2.m();
                fragment.mRemoving = true;
                uVar2.m();
            }
        }
        this.f9391c.w(fragmentManagerState.f9442b);
        if (fragmentManagerState.f9443c != null) {
            this.f9392d = new ArrayList(fragmentManagerState.f9443c.length);
            int i11 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f9443c;
                if (i11 >= backStackRecordStateArr.length) {
                    break;
                }
                androidx.fragment.app.a b11 = backStackRecordStateArr[i11].b(this);
                if (M0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i11 + " (index " + b11.f9506v + "): " + b11);
                    PrintWriter printWriter = new PrintWriter(new a0("FragmentManager"));
                    b11.D("  ", printWriter, false);
                    printWriter.close();
                }
                this.f9392d.add(b11);
                i11++;
            }
        } else {
            this.f9392d = null;
        }
        this.f9397i.set(fragmentManagerState.f9444d);
        String str3 = fragmentManagerState.f9445e;
        if (str3 != null) {
            Fragment h02 = h0(str3);
            this.f9413y = h02;
            N(h02);
        }
        ArrayList arrayList2 = fragmentManagerState.f9446f;
        if (arrayList2 != null) {
            for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                this.f9398j.put((String) arrayList2.get(i12), (BackStackState) fragmentManagerState.f9447g.get(i12));
            }
        }
        this.G = new ArrayDeque(fragmentManagerState.f9448h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u x(Fragment fragment) {
        u n11 = this.f9391c.n(fragment.mWho);
        if (n11 != null) {
            return n11;
        }
        u uVar = new u(this.f9402n, this.f9391c, fragment);
        uVar.o(this.f9410v.f().getClassLoader());
        uVar.u(this.f9409u);
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v x0() {
        return this.f9391c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (M0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f9391c.u(fragment);
            if (N0(fragment)) {
                this.H = true;
            }
            J1(fragment);
        }
    }

    public List y0() {
        return this.f9391c.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public Bundle U0() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        o0();
        Z();
        c0(true);
        this.I = true;
        this.P.m(true);
        ArrayList y10 = this.f9391c.y();
        ArrayList m11 = this.f9391c.m();
        if (!m11.isEmpty()) {
            ArrayList z10 = this.f9391c.z();
            ArrayList arrayList = this.f9392d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i11 = 0; i11 < size; i11++) {
                    backStackRecordStateArr[i11] = new BackStackRecordState((androidx.fragment.app.a) this.f9392d.get(i11));
                    if (M0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i11 + ": " + this.f9392d.get(i11));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f9441a = y10;
            fragmentManagerState.f9442b = z10;
            fragmentManagerState.f9443c = backStackRecordStateArr;
            fragmentManagerState.f9444d = this.f9397i.get();
            Fragment fragment = this.f9413y;
            if (fragment != null) {
                fragmentManagerState.f9445e = fragment.mWho;
            }
            fragmentManagerState.f9446f.addAll(this.f9398j.keySet());
            fragmentManagerState.f9447g.addAll(this.f9398j.values());
            fragmentManagerState.f9448h = new ArrayList(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f9399k.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.f9399k.get(str));
            }
            Iterator it = m11.iterator();
            while (it.hasNext()) {
                FragmentState fragmentState = (FragmentState) it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle("fragment_" + fragmentState.f9450b, bundle2);
            }
        } else if (M0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        this.I = false;
        this.J = false;
        this.P.m(false);
        U(4);
    }

    public androidx.fragment.app.i z0() {
        return this.f9410v;
    }

    public void z1(String str) {
        a0(new p(str), false);
    }
}
