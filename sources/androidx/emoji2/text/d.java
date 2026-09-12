package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class d {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final b f9152a;

        public a(b bVar) {
            this.f9152a = bVar == null ? e() : bVar;
        }

        private EmojiCompat.c a(Context context, androidx.core.provider.e eVar) {
            if (eVar == null) {
                return null;
            }
            return new j(context, eVar);
        }

        private List b(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        private androidx.core.provider.e d(ProviderInfo providerInfo, PackageManager packageManager) {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new androidx.core.provider.e(str, str2, "emojicompat-emoji-font", b(this.f9152a.b(packageManager, str2)));
        }

        private static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new C0087d() : new c();
        }

        private boolean f(ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        private ProviderInfo g(PackageManager packageManager) {
            Iterator it = this.f9152a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo a11 = this.f9152a.a((ResolveInfo) it.next());
                if (f(a11)) {
                    return a11;
                }
            }
            return null;
        }

        public EmojiCompat.c c(Context context) {
            return a(context, h(context));
        }

        androidx.core.provider.e h(Context context) {
            PackageManager packageManager = context.getPackageManager();
            androidx.core.util.i.h(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo g11 = g(packageManager);
            if (g11 == null) {
                return null;
            }
            try {
                return d(g11, packageManager);
            } catch (PackageManager.NameNotFoundException e11) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e11);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public ProviderInfo a(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List c(PackageManager packageManager, Intent intent, int i11) {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b {
        @Override // androidx.emoji2.text.d.b
        public ProviderInfo a(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.d.b
        public List c(PackageManager packageManager, Intent intent, int i11) {
            return packageManager.queryIntentContentProviders(intent, i11);
        }
    }

    /* renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0087d extends c {
        @Override // androidx.emoji2.text.d.b
        public Signature[] b(PackageManager packageManager, String str) {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    public static j a(Context context) {
        return (j) new a(null).c(context);
    }
}
