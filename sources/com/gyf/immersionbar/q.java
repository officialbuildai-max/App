package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class q implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final String f33182a;

    /* renamed from: b, reason: collision with root package name */
    private final String f33183b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f33184c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f33185d;

    /* renamed from: e, reason: collision with root package name */
    private final Map f33186e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f33187f;

    /* renamed from: g, reason: collision with root package name */
    private final Map f33188g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final q f33189a = new q();
    }

    private q() {
        this.f33182a = ImmersionBar.class.getName() + ".";
        this.f33183b = ".tag.notOnly.";
        this.f33185d = new HashMap();
        this.f33186e = new HashMap();
        this.f33187f = new HashMap();
        this.f33188g = new HashMap();
        this.f33184c = new Handler(Looper.getMainLooper(), this);
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    private o g(FragmentManager fragmentManager, String str) {
        return h(fragmentManager, str, false);
    }

    private o h(FragmentManager fragmentManager, String str, boolean z10) {
        List<Fragment> fragments;
        o oVar = (o) fragmentManager.findFragmentByTag(str);
        if (oVar == null && (oVar = (o) this.f33185d.get(fragmentManager)) == null) {
            if (z10) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                fragments = fragmentManager.getFragments();
                for (Fragment fragment : fragments) {
                    if (fragment instanceof o) {
                        String tag = fragment.getTag();
                        if (tag == null) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        } else if (tag.contains(".tag.notOnly.")) {
                            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        }
                    }
                }
            }
            oVar = new o();
            this.f33185d.put(fragmentManager, oVar);
            fragmentManager.beginTransaction().add(oVar, str).commitAllowingStateLoss();
            this.f33184c.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z10) {
            return oVar;
        }
        if (this.f33187f.get(str) == null) {
            this.f33187f.put(str, oVar);
            fragmentManager.beginTransaction().remove(oVar).commitAllowingStateLoss();
            this.f33184c.obtainMessage(3, str).sendToTarget();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q i() {
        return b.f33189a;
    }

    private SupportRequestBarManagerFragment j(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return k(fragmentManager, str, false);
    }

    private SupportRequestBarManagerFragment k(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z10) {
        SupportRequestBarManagerFragment supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) fragmentManager.k0(str);
        if (supportRequestBarManagerFragment == null && (supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) this.f33186e.get(fragmentManager)) == null) {
            if (z10) {
                return null;
            }
            for (androidx.fragment.app.Fragment fragment : fragmentManager.y0()) {
                if (fragment instanceof SupportRequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.p().r(fragment).j();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.p().r(fragment).j();
                    }
                }
            }
            supportRequestBarManagerFragment = new SupportRequestBarManagerFragment();
            this.f33186e.put(fragmentManager, supportRequestBarManagerFragment);
            fragmentManager.p().e(supportRequestBarManagerFragment, str).j();
            this.f33184c.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z10) {
            return supportRequestBarManagerFragment;
        }
        if (this.f33188g.get(str) == null) {
            this.f33188g.put(str, supportRequestBarManagerFragment);
            fragmentManager.p().r(supportRequestBarManagerFragment).j();
            this.f33184c.obtainMessage(4, str).sendToTarget();
        }
        return null;
    }

    public void b(Activity activity, Dialog dialog, boolean z10) {
        if (activity == null || dialog == null) {
            return;
        }
        String str = this.f33182a + dialog.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        if (activity instanceof FragmentActivity) {
            k(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
        } else {
            h(activity.getFragmentManager(), str, true);
        }
    }

    public ImmersionBar c(Activity activity, Dialog dialog, boolean z10) {
        a(activity, "activity is null");
        a(dialog, "dialog is null");
        String str = this.f33182a + dialog.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? j(((FragmentActivity) activity).getSupportFragmentManager(), str).V(activity, dialog) : g(activity.getFragmentManager(), str).a(activity, dialog);
    }

    public ImmersionBar d(Activity activity, boolean z10) {
        a(activity, "activity is null");
        String str = this.f33182a + activity.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(activity) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? j(((FragmentActivity) activity).getSupportFragmentManager(), str).W(activity) : g(activity.getFragmentManager(), str).b(activity);
    }

    public ImmersionBar e(Fragment fragment, boolean z10) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f33182a + fragment.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return g(fragment.getChildFragmentManager(), str).b(fragment);
    }

    public ImmersionBar f(androidx.fragment.app.Fragment fragment, boolean z10) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof androidx.fragment.app.DialogFragment) {
            a(((androidx.fragment.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f33182a + fragment.getClass().getName();
        if (!z10) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return j(fragment.getChildFragmentManager(), str).W(fragment);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            this.f33185d.remove((FragmentManager) message.obj);
            return true;
        }
        if (i11 == 2) {
            this.f33186e.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
        if (i11 == 3) {
            this.f33187f.remove((String) message.obj);
            return true;
        }
        if (i11 != 4) {
            return false;
        }
        this.f33188g.remove((String) message.obj);
        return true;
    }
}
