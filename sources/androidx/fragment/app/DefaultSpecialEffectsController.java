package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.e;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9317a;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            f9317a = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9317a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9317a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9317a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f9318a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f9319b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f9320c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f9321d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f9322e;

        b(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, e eVar) {
            this.f9318a = viewGroup;
            this.f9319b = view;
            this.f9320c = z10;
            this.f9321d = operation;
            this.f9322e = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9318a.endViewTransition(this.f9319b);
            if (this.f9320c) {
                this.f9321d.e().applyState(this.f9319b);
            }
            this.f9322e.a();
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f9321d + " has ended.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f9324a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f9325b;

        c(Animator animator, SpecialEffectsController.Operation operation) {
            this.f9324a = animator;
            this.f9325b = operation;
        }

        @Override // androidx.core.os.e.a
        public void onCancel() {
            this.f9324a.end();
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f9325b + " has been canceled.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f9327a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f9328b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f9329c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f9330d;

        d(View view, ViewGroup viewGroup, e eVar, SpecialEffectsController.Operation operation) {
            this.f9327a = view;
            this.f9328b = viewGroup;
            this.f9329c = eVar;
            this.f9330d = operation;
        }

        @Override // androidx.core.os.e.a
        public void onCancel() {
            this.f9327a.clearAnimation();
            this.f9328b.endViewTransition(this.f9327a);
            this.f9329c.a();
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f9330d + " has been cancelled.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends f {

        /* renamed from: c, reason: collision with root package name */
        private boolean f9332c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f9333d;

        /* renamed from: e, reason: collision with root package name */
        private FragmentAnim.a f9334e;

        e(SpecialEffectsController.Operation operation, androidx.core.os.e eVar, boolean z10) {
            super(operation, eVar);
            this.f9333d = false;
            this.f9332c = z10;
        }

        FragmentAnim.a e(Context context) {
            if (this.f9333d) {
                return this.f9334e;
            }
            FragmentAnim.a b11 = FragmentAnim.b(context, b().f(), b().e() == SpecialEffectsController.Operation.State.VISIBLE, this.f9332c);
            this.f9334e = b11;
            this.f9333d = true;
            return b11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final SpecialEffectsController.Operation f9335a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.os.e f9336b;

        f(SpecialEffectsController.Operation operation, androidx.core.os.e eVar) {
            this.f9335a = operation;
            this.f9336b = eVar;
        }

        void a() {
            this.f9335a.d(this.f9336b);
        }

        SpecialEffectsController.Operation b() {
            return this.f9335a;
        }

        androidx.core.os.e c() {
            return this.f9336b;
        }

        boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.f9335a.f().mView);
            SpecialEffectsController.Operation.State e11 = this.f9335a.e();
            return from == e11 || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || e11 == state);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g extends f {

        /* renamed from: c, reason: collision with root package name */
        private final Object f9337c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f9338d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f9339e;

        g(SpecialEffectsController.Operation operation, androidx.core.os.e eVar, boolean z10, boolean z11) {
            super(operation, eVar);
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.f9337c = z10 ? operation.f().getReenterTransition() : operation.f().getEnterTransition();
                this.f9338d = z10 ? operation.f().getAllowReturnTransitionOverlap() : operation.f().getAllowEnterTransitionOverlap();
            } else {
                this.f9337c = z10 ? operation.f().getReturnTransition() : operation.f().getExitTransition();
                this.f9338d = true;
            }
            if (!z11) {
                this.f9339e = null;
            } else if (z10) {
                this.f9339e = operation.f().getSharedElementReturnTransition();
            } else {
                this.f9339e = operation.f().getSharedElementEnterTransition();
            }
        }

        private FragmentTransitionImpl f(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = x.f9586a;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.e(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = x.f9587b;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.e(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        FragmentTransitionImpl e() {
            FragmentTransitionImpl f11 = f(this.f9337c);
            FragmentTransitionImpl f12 = f(this.f9339e);
            if (f11 == null || f12 == null || f11 == f12) {
                return f11 != null ? f11 : f12;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f9337c + " which uses a different Transition  type than its shared element transition " + this.f9339e);
        }

        public Object g() {
            return this.f9339e;
        }

        Object h() {
            return this.f9337c;
        }

        public boolean i() {
            return this.f9339e != null;
        }

        boolean j() {
            return this.f9338d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z10, Map map) {
        int i11;
        boolean z11;
        Context context;
        View view;
        int i12;
        SpecialEffectsController.Operation operation;
        final ViewGroup m11 = m();
        Context context2 = m11.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z12 = false;
        while (true) {
            i11 = 2;
            if (!it.hasNext()) {
                break;
            }
            e eVar = (e) it.next();
            if (eVar.d()) {
                eVar.a();
            } else {
                FragmentAnim.a e11 = eVar.e(context2);
                if (e11 == null) {
                    eVar.a();
                } else {
                    Animator animator = e11.f9383b;
                    if (animator == null) {
                        arrayList.add(eVar);
                    } else {
                        SpecialEffectsController.Operation b11 = eVar.b();
                        Fragment f11 = b11.f();
                        if (Boolean.TRUE.equals(map.get(b11))) {
                            if (FragmentManager.M0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f11 + " as this Fragment was involved in a Transition.");
                            }
                            eVar.a();
                        } else {
                            boolean z13 = b11.e() == SpecialEffectsController.Operation.State.GONE;
                            if (z13) {
                                list2.remove(b11);
                            }
                            View view2 = f11.mView;
                            m11.startViewTransition(view2);
                            animator.addListener(new b(m11, view2, z13, b11, eVar));
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.M0(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Animator from operation ");
                                operation = b11;
                                sb2.append(operation);
                                sb2.append(" has started.");
                                Log.v("FragmentManager", sb2.toString());
                            } else {
                                operation = b11;
                            }
                            eVar.c().b(new c(animator, operation));
                            z12 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final e eVar2 = (e) it2.next();
            final SpecialEffectsController.Operation b12 = eVar2.b();
            Fragment f12 = b12.f();
            if (z10) {
                if (FragmentManager.M0(i11)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f12 + " as Animations cannot run alongside Transitions.");
                }
                eVar2.a();
            } else if (z12) {
                if (FragmentManager.M0(i11)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f12 + " as Animations cannot run alongside Animators.");
                }
                eVar2.a();
            } else {
                final View view3 = f12.mView;
                Animation animation = (Animation) androidx.core.util.i.g(((FragmentAnim.a) androidx.core.util.i.g(eVar2.e(context2))).f9382a);
                if (b12.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation);
                    eVar2.a();
                    z11 = z12;
                    context = context2;
                    i12 = i11;
                    view = view3;
                } else {
                    m11.startViewTransition(view3);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, m11, view3);
                    z11 = z12;
                    context = context2;
                    view = view3;
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            m11.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    m11.endViewTransition(view3);
                                    eVar2.a();
                                }
                            });
                            if (FragmentManager.M0(2)) {
                                Log.v("FragmentManager", "Animation from operation " + b12 + " has ended.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                            if (FragmentManager.M0(2)) {
                                Log.v("FragmentManager", "Animation from operation " + b12 + " has reached onAnimationStart.");
                            }
                        }
                    });
                    view.startAnimation(endViewTransitionAnimation);
                    i12 = 2;
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + b12 + " has started.");
                    }
                }
                eVar2.c().b(new d(view, m11, eVar2, b12));
                i11 = i12;
                z12 = z11;
                context2 = context;
            }
        }
    }

    private Map x(List list, List list2, final boolean z10, final SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        View view2;
        androidx.collection.a aVar;
        SpecialEffectsController.Operation operation5;
        HashMap hashMap;
        ArrayList arrayList3;
        View view3;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList arrayList4;
        SpecialEffectsController.Operation operation6;
        final Rect rect;
        androidx.core.app.a0 enterTransitionCallback;
        androidx.core.app.a0 exitTransitionCallback;
        ArrayList<String> arrayList5;
        int i11;
        final View view4;
        String b11;
        ArrayList<String> arrayList6;
        boolean z11 = z10;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap hashMap2 = new HashMap();
        Iterator it = list.iterator();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (!gVar.d()) {
                FragmentTransitionImpl e11 = gVar.e();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = e11;
                } else if (e11 != null && fragmentTransitionImpl2 != e11) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + gVar.b().f() + " returned Transition " + gVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                g gVar2 = (g) it2.next();
                hashMap2.put(gVar2.b(), Boolean.FALSE);
                gVar2.a();
            }
            return hashMap2;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z12 = false;
        while (true) {
            str = "FragmentManager";
            if (!it3.hasNext()) {
                break;
            }
            g gVar3 = (g) it3.next();
            if (!gVar3.i() || operation7 == null || operation8 == null) {
                aVar = aVar2;
                operation5 = operation7;
                hashMap = hashMap2;
                arrayList3 = arrayList7;
                view3 = view5;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                arrayList4 = arrayList8;
                operation6 = operation8;
                rect = rect2;
                view6 = view6;
            } else {
                Object u11 = fragmentTransitionImpl2.u(fragmentTransitionImpl2.f(gVar3.g()));
                ArrayList<String> sharedElementSourceNames = operation2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.f().getSharedElementTargetNames();
                View view7 = view6;
                HashMap hashMap3 = hashMap2;
                int i12 = 0;
                while (i12 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i12));
                    ArrayList<String> arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i12));
                    }
                    i12++;
                    sharedElementTargetNames = arrayList9;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.f().getSharedElementTargetNames();
                if (z11) {
                    enterTransitionCallback = operation.f().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.f().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.f().getExitTransitionCallback();
                    exitTransitionCallback = operation2.f().getEnterTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                View view8 = view5;
                int i13 = 0;
                while (i13 < size) {
                    aVar2.put(sharedElementSourceNames.get(i13), sharedElementTargetNames2.get(i13));
                    i13++;
                    size = size;
                    rect2 = rect2;
                }
                Rect rect3 = rect2;
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it4 = sharedElementTargetNames2.iterator(); it4.hasNext(); it4 = it4) {
                        Log.v("FragmentManager", "Name: " + it4.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it5 = sharedElementSourceNames.iterator(); it5.hasNext(); it5 = it5) {
                        Log.v("FragmentManager", "Name: " + it5.next());
                    }
                }
                androidx.collection.a aVar3 = new androidx.collection.a();
                u(aVar3, operation.f().mView);
                aVar3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Executing exit callback for operation " + operation7);
                    }
                    enterTransitionCallback.d(sharedElementSourceNames, aVar3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str4 = sharedElementSourceNames.get(size2);
                        View view9 = (View) aVar3.get(str4);
                        if (view9 == null) {
                            aVar2.remove(str4);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str4.equals(ViewCompat.getTransitionName(view9))) {
                                aVar2.put(ViewCompat.getTransitionName(view9), (String) aVar2.remove(str4));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    aVar2.retainAll(aVar3.keySet());
                }
                final androidx.collection.a aVar4 = new androidx.collection.a();
                u(aVar4, operation2.f().mView);
                aVar4.retainAll(sharedElementTargetNames2);
                aVar4.retainAll(aVar2.values());
                if (exitTransitionCallback != null) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Executing enter callback for operation " + operation8);
                    }
                    exitTransitionCallback.d(sharedElementTargetNames2, aVar4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str5 = sharedElementTargetNames2.get(size3);
                        View view10 = (View) aVar4.get(str5);
                        if (view10 == null) {
                            String b12 = x.b(aVar2, str5);
                            if (b12 != null) {
                                aVar2.remove(b12);
                            }
                        } else if (!str5.equals(ViewCompat.getTransitionName(view10)) && (b11 = x.b(aVar2, str5)) != null) {
                            aVar2.put(b11, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    x.d(aVar2, aVar4);
                }
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    aVar = aVar2;
                    arrayList4 = arrayList8;
                    operation5 = operation7;
                    arrayList3 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view6 = view7;
                    view3 = view8;
                    hashMap = hashMap3;
                    rect = rect3;
                    obj3 = null;
                    operation6 = operation8;
                } else {
                    x.a(operation2.f(), operation.f(), z11, aVar3, true);
                    aVar = aVar2;
                    ArrayList arrayList10 = arrayList8;
                    OneShotPreDrawListener.add(m(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            x.a(operation2.f(), operation.f(), z10, aVar4, false);
                        }
                    });
                    arrayList7.addAll(aVar3.values());
                    if (arrayList5.isEmpty()) {
                        i11 = 0;
                        view6 = view7;
                    } else {
                        i11 = 0;
                        view6 = (View) aVar3.get((String) arrayList5.get(0));
                        fragmentTransitionImpl2.p(u11, view6);
                    }
                    arrayList10.addAll(aVar4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view4 = (View) aVar4.get((String) sharedElementTargetNames2.get(i11))) == null) {
                        rect = rect3;
                        view3 = view8;
                    } else {
                        rect = rect3;
                        OneShotPreDrawListener.add(m(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.h(view4, rect);
                            }
                        });
                        view3 = view8;
                        z12 = true;
                    }
                    fragmentTransitionImpl2.s(u11, view3, arrayList7);
                    arrayList3 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.n(u11, null, null, null, null, u11, arrayList10);
                    Boolean bool = Boolean.TRUE;
                    operation5 = operation;
                    arrayList4 = arrayList10;
                    hashMap = hashMap3;
                    hashMap.put(operation5, bool);
                    operation6 = operation2;
                    hashMap.put(operation6, bool);
                    obj3 = u11;
                }
            }
            view5 = view3;
            rect2 = rect;
            arrayList7 = arrayList3;
            arrayList8 = arrayList4;
            operation8 = operation6;
            z11 = z10;
            hashMap2 = hashMap;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            operation7 = operation5;
            aVar2 = aVar;
        }
        View view11 = view6;
        androidx.collection.a aVar5 = aVar2;
        SpecialEffectsController.Operation operation9 = operation7;
        HashMap hashMap4 = hashMap2;
        ArrayList arrayList11 = arrayList7;
        View view12 = view5;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        ArrayList arrayList12 = arrayList8;
        SpecialEffectsController.Operation operation10 = operation8;
        Rect rect4 = rect2;
        ArrayList arrayList13 = new ArrayList();
        Iterator it6 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it6.hasNext()) {
            g gVar4 = (g) it6.next();
            if (gVar4.d()) {
                hashMap4.put(gVar4.b(), Boolean.FALSE);
                gVar4.a();
                it6 = it6;
            } else {
                Iterator it7 = it6;
                Object f11 = fragmentTransitionImpl3.f(gVar4.h());
                SpecialEffectsController.Operation b13 = gVar4.b();
                boolean z13 = obj3 != null && (b13 == operation9 || b13 == operation10);
                if (f11 == null) {
                    if (!z13) {
                        hashMap4.put(b13, Boolean.FALSE);
                        gVar4.a();
                    }
                    view = view12;
                    str3 = str;
                    arrayList = arrayList11;
                    arrayList2 = arrayList12;
                    obj = obj4;
                    obj2 = obj5;
                    operation3 = operation10;
                    view2 = view11;
                } else {
                    str3 = str;
                    final ArrayList arrayList14 = new ArrayList();
                    Object obj6 = obj4;
                    t(arrayList14, b13.f().mView);
                    if (z13) {
                        if (b13 == operation9) {
                            arrayList14.removeAll(arrayList11);
                        } else {
                            arrayList14.removeAll(arrayList12);
                        }
                    }
                    if (arrayList14.isEmpty()) {
                        fragmentTransitionImpl3.a(f11, view12);
                        view = view12;
                        arrayList = arrayList11;
                        arrayList2 = arrayList12;
                        obj2 = obj5;
                        operation4 = b13;
                        operation3 = operation10;
                        obj = obj6;
                    } else {
                        fragmentTransitionImpl3.b(f11, arrayList14);
                        view = view12;
                        obj = obj6;
                        arrayList = arrayList11;
                        obj2 = obj5;
                        arrayList2 = arrayList12;
                        operation3 = operation10;
                        fragmentTransitionImpl3.n(f11, f11, arrayList14, null, null, null, null);
                        if (b13.e() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = b13;
                            list2.remove(operation4);
                            ArrayList arrayList15 = new ArrayList(arrayList14);
                            arrayList15.remove(operation4.f().mView);
                            fragmentTransitionImpl3.m(f11, operation4.f().mView, arrayList15);
                            OneShotPreDrawListener.add(m(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    x.e(arrayList14, 4);
                                }
                            });
                        } else {
                            operation4 = b13;
                        }
                    }
                    if (operation4.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList13.addAll(arrayList14);
                        if (z12) {
                            fragmentTransitionImpl3.o(f11, rect4);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        fragmentTransitionImpl3.p(f11, view2);
                    }
                    hashMap4.put(operation4, Boolean.TRUE);
                    if (gVar4.j()) {
                        obj2 = fragmentTransitionImpl3.k(obj2, f11, null);
                    } else {
                        obj = fragmentTransitionImpl3.k(obj, f11, null);
                    }
                }
                it6 = it7;
                obj4 = obj;
                view11 = view2;
                obj5 = obj2;
                operation10 = operation3;
                str = str3;
                view12 = view;
                arrayList11 = arrayList;
                arrayList12 = arrayList2;
            }
        }
        String str6 = str;
        ArrayList arrayList16 = arrayList11;
        ArrayList arrayList17 = arrayList12;
        SpecialEffectsController.Operation operation11 = operation10;
        Object j11 = fragmentTransitionImpl3.j(obj5, obj4, obj3);
        if (j11 == null) {
            return hashMap4;
        }
        Iterator it8 = list.iterator();
        while (it8.hasNext()) {
            final g gVar5 = (g) it8.next();
            if (!gVar5.d()) {
                Object h11 = gVar5.h();
                final SpecialEffectsController.Operation b14 = gVar5.b();
                boolean z14 = obj3 != null && (b14 == operation9 || b14 == operation11);
                if (h11 == null && !z14) {
                    str2 = str6;
                } else if (ViewCompat.isLaidOut(m())) {
                    str2 = str6;
                    fragmentTransitionImpl3.q(gVar5.b().f(), j11, gVar5.c(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar5.a();
                            if (FragmentManager.M0(2)) {
                                Log.v("FragmentManager", "Transition for operation " + b14 + "has completed");
                            }
                        }
                    });
                } else {
                    if (FragmentManager.M0(2)) {
                        str2 = str6;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b14);
                    } else {
                        str2 = str6;
                    }
                    gVar5.a();
                }
                str6 = str2;
            }
        }
        String str7 = str6;
        if (!ViewCompat.isLaidOut(m())) {
            return hashMap4;
        }
        x.e(arrayList13, 4);
        ArrayList l11 = fragmentTransitionImpl3.l(arrayList17);
        if (FragmentManager.M0(2)) {
            Log.v(str7, ">>>>> Beginning transition <<<<<");
            Log.v(str7, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator it9 = arrayList16.iterator();
            while (it9.hasNext()) {
                View view13 = (View) it9.next();
                Log.v(str7, "View: " + view13 + " Name: " + ViewCompat.getTransitionName(view13));
            }
            Log.v(str7, ">>>>> SharedElementLastInViews <<<<<");
            Iterator it10 = arrayList17.iterator();
            while (it10.hasNext()) {
                View view14 = (View) it10.next();
                Log.v(str7, "View: " + view14 + " Name: " + ViewCompat.getTransitionName(view14));
            }
        }
        fragmentTransitionImpl3.c(m(), j11);
        fragmentTransitionImpl3.r(m(), arrayList16, arrayList17, l11, aVar5);
        x.e(arrayList13, 0);
        fragmentTransitionImpl3.t(obj3, arrayList16, arrayList17);
        return hashMap4;
    }

    private void y(List list) {
        Fragment f11 = ((SpecialEffectsController.Operation) list.get(list.size() - 1)).f();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) it.next();
            operation.f().mAnimationInfo.f9361c = f11.mAnimationInfo.f9361c;
            operation.f().mAnimationInfo.f9362d = f11.mAnimationInfo.f9362d;
            operation.f().mAnimationInfo.f9363e = f11.mAnimationInfo.f9363e;
            operation.f().mAnimationInfo.f9364f = f11.mAnimationInfo.f9364f;
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void f(List list, boolean z10) {
        Iterator it = list.iterator();
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) it.next();
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.f().mView);
            int i11 = a.f9317a[operation3.e().ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i11 == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        y(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it2.next();
            androidx.core.os.e eVar = new androidx.core.os.e();
            operation4.j(eVar);
            arrayList.add(new e(operation4, eVar, z10));
            androidx.core.os.e eVar2 = new androidx.core.os.e();
            operation4.j(eVar2);
            boolean z11 = false;
            if (z10) {
                if (operation4 != operation) {
                    arrayList2.add(new g(operation4, eVar2, z10, z11));
                    operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.s(operation4);
                            }
                        }
                    });
                }
                z11 = true;
                arrayList2.add(new g(operation4, eVar2, z10, z11));
                operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.s(operation4);
                        }
                    }
                });
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new g(operation4, eVar2, z10, z11));
                    operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.s(operation4);
                            }
                        }
                    });
                }
                z11 = true;
                arrayList2.add(new g(operation4, eVar2, z10, z11));
                operation4.a(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.s(operation4);
                        }
                    }
                });
            }
        }
        Map x10 = x(arrayList2, arrayList3, z10, operation, operation2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            s((SpecialEffectsController.Operation) it3.next());
        }
        arrayList3.clear();
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    void s(SpecialEffectsController.Operation operation) {
        operation.e().applyState(operation.f().mView);
    }

    void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(androidx.collection.a aVar, Collection collection) {
        Iterator<Map.Entry<Object, Object>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
