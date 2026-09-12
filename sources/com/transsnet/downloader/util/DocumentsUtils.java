package com.transsnet.downloader.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.transsnet.downloader.util.DocumentsUtils;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class DocumentsUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final DocumentsUtils f60013a = new DocumentsUtils();

    /* renamed from: b, reason: collision with root package name */
    private static final String f60014b = DocumentsUtils.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    private static final List f60015c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private static Function1 f60016d;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/transsnet/downloader/util/DocumentsUtils$DocumentsPermissionTransActivityImpl;", "Lcom/blankj/utilcode/util/UtilsTransActivity$TransActivityDelegate;", "<init>", "()V", "Lcom/blankj/utilcode/util/UtilsTransActivity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreated", "(Lcom/blankj/utilcode/util/UtilsTransActivity;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(Lcom/blankj/utilcode/util/UtilsTransActivity;IILandroid/content/Intent;)V", "onDestroy", "(Lcom/blankj/utilcode/util/UtilsTransActivity;)V", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "Companion", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes7.dex */
    public static final class DocumentsPermissionTransActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static final String ROOT_PATH = "extra_root_path";
        private Uri uri;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<DocumentsPermissionTransActivityImpl> instance$delegate = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DocumentsUtils.DocumentsPermissionTransActivityImpl instance_delegate$lambda$2;
                instance_delegate$lambda$2 = DocumentsUtils.DocumentsPermissionTransActivityImpl.instance_delegate$lambda$2();
                return instance_delegate$lambda$2;
            }
        });

        /* renamed from: com.transsnet.downloader.util.DocumentsUtils$DocumentsPermissionTransActivityImpl$a, reason: from kotlin metadata */
        /* loaded from: classes7.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(String str, Intent intent) {
                intent.putExtra(DocumentsPermissionTransActivityImpl.ROOT_PATH, str);
            }

            public final DocumentsPermissionTransActivityImpl b() {
                return (DocumentsPermissionTransActivityImpl) DocumentsPermissionTransActivityImpl.instance$delegate.getValue();
            }

            public final void c(final String rootPath) {
                Intrinsics.h(rootPath, "rootPath");
                UtilsTransActivity.T(new Utils.b() { // from class: com.transsnet.downloader.util.g
                    @Override // com.blankj.utilcode.util.Utils.b
                    public final void accept(Object obj) {
                        DocumentsUtils.DocumentsPermissionTransActivityImpl.Companion.d(rootPath, (Intent) obj);
                    }
                }, b());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DocumentsPermissionTransActivityImpl instance_delegate$lambda$2() {
            return new DocumentsPermissionTransActivityImpl();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(UtilsTransActivity activity, int requestCode, int resultCode, Intent data) {
            Intrinsics.h(activity, "activity");
            this.uri = data != null ? data.getData() : null;
            activity.finish();
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        
            r5 = ((android.os.storage.StorageManager) r4.getSystemService(android.os.storage.StorageManager.class)).getStorageVolume(new java.io.File(r5));
         */
        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onCreated(com.blankj.utilcode.util.UtilsTransActivity r4, android.os.Bundle r5) {
            /*
                r3 = this;
                java.lang.String r5 = "activity"
                kotlin.jvm.internal.Intrinsics.h(r4, r5)
                android.view.Window r5 = r4.getWindow()
                r0 = 262160(0x40010, float:3.67364E-40)
                r5.addFlags(r0)
                android.content.Intent r5 = r4.getIntent()
                java.lang.String r0 = "extra_root_path"
                java.lang.String r5 = r5.getStringExtra(r0)
                if (r5 == 0) goto L7c
                int r0 = r5.length()
                if (r0 != 0) goto L22
                goto L7c
            L22:
                kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L50
                boolean r0 = r4.isFinishing()     // Catch: java.lang.Throwable -> L50
                if (r0 != 0) goto L67
                boolean r0 = r4.isDestroyed()     // Catch: java.lang.Throwable -> L50
                if (r0 == 0) goto L31
                goto L67
            L31:
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L50
                r1 = 24
                r2 = 0
                if (r0 < r1) goto L52
                java.lang.Class<android.os.storage.StorageManager> r0 = android.os.storage.StorageManager.class
                java.lang.Object r0 = r4.getSystemService(r0)     // Catch: java.lang.Throwable -> L50
                android.os.storage.StorageManager r0 = (android.os.storage.StorageManager) r0     // Catch: java.lang.Throwable -> L50
                java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L50
                r1.<init>(r5)     // Catch: java.lang.Throwable -> L50
                android.os.storage.StorageVolume r5 = com.transsnet.downloader.dialog.o.a(r0, r1)     // Catch: java.lang.Throwable -> L50
                if (r5 == 0) goto L52
                android.content.Intent r2 = com.transsnet.downloader.dialog.p.a(r5, r2)     // Catch: java.lang.Throwable -> L50
                goto L52
            L50:
                r5 = move-exception
                goto L68
            L52:
                if (r2 != 0) goto L5b
                android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L50
                java.lang.String r5 = "android.intent.action.OPEN_DOCUMENT_TREE"
                r2.<init>(r5)     // Catch: java.lang.Throwable -> L50
            L5b:
                r5 = 10011(0x271b, float:1.4028E-41)
                r4.startActivityForResult(r2, r5)     // Catch: java.lang.Throwable -> L50
                kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L50
                java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r5)     // Catch: java.lang.Throwable -> L50
                goto L72
            L67:
                return
            L68:
                kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
                java.lang.Object r5 = kotlin.ResultKt.a(r5)
                java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r5)
            L72:
                java.lang.Throwable r5 = kotlin.Result.m1188exceptionOrNullimpl(r5)
                if (r5 == 0) goto L7b
                r4.finish()
            L7b:
                return
            L7c:
                r4.finish()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.util.DocumentsUtils.DocumentsPermissionTransActivityImpl.onCreated(com.blankj.utilcode.util.UtilsTransActivity, android.os.Bundle):void");
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(UtilsTransActivity activity) {
            Intrinsics.h(activity, "activity");
            Function1 function1 = DocumentsUtils.f60016d;
            if (function1 != null) {
                function1.invoke(this.uri);
            }
        }
    }

    private DocumentsUtils() {
    }

    private final String f(File file, Context context) {
        String[] g11 = g();
        try {
            int length = g11.length;
            for (int i11 = 0; i11 < length; i11++) {
                String canonicalPath = file.getCanonicalPath();
                Intrinsics.g(canonicalPath, "getCanonicalPath(...)");
                if (StringsKt.W(canonicalPath, g11[i11], false, 2, null)) {
                    return g11[i11];
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    private final String[] g() {
        List list = f60015c;
        if (list.size() > 0) {
            return (String[]) list.toArray(new String[0]);
        }
        Iterator it = DownloadSDCardUtil.f60017a.b().iterator();
        while (it.hasNext()) {
            f60015c.add(((my.f) it.next()).b());
        }
        return (String[]) f60015c.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1, Uri uri) {
        function1.invoke(uri);
        f60016d = null;
        return Unit.f67184a;
    }

    public final boolean c(File file) {
        Intrinsics.h(file, "file");
        boolean z10 = true;
        boolean z11 = false;
        boolean z12 = file.exists() && file.canWrite();
        if (z12 || file.exists()) {
            return z12;
        }
        try {
            try {
                if (file.isDirectory()) {
                    if (!file.mkdirs() || !file.delete()) {
                        z10 = false;
                    }
                } else if (!file.createNewFile() || !file.delete()) {
                    z10 = false;
                }
                z11 = z10;
            } catch (Throwable unused) {
            }
            return z11;
        } catch (IOException e11) {
            e11.printStackTrace();
            return z12;
        }
    }

    public final boolean d(Context context, String rootPath) {
        k1.a h11;
        Intrinsics.h(context, "context");
        Intrinsics.h(rootPath, "rootPath");
        File file = new File(rootPath);
        if (file.canWrite()) {
            return false;
        }
        if (j(file, context)) {
            k1.a e11 = e(file, true, context);
            if (e11 != null && e11.a()) {
                return false;
            }
        } else {
            String string = com.transsion.baselib.report.launch.b.f43424a.b().getString(rootPath, "");
            if (string != null && string.length() != 0 && (h11 = k1.a.h(context, Uri.parse(string))) != null && h11.a()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k1.a e(java.io.File r8, boolean r9, android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.util.DocumentsUtils.e(java.io.File, boolean, android.content.Context):k1.a");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003b -> B:12:0x003c). Please report as a decompilation issue!!! */
    public final InputStream h(Context context, File destFile) {
        InputStream inputStream;
        Intrinsics.h(context, "context");
        Intrinsics.h(destFile, "destFile");
        try {
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        }
        if (c(destFile) || !j(destFile, context)) {
            inputStream = new FileInputStream(destFile);
        } else {
            k1.a e12 = e(destFile, false, context);
            if (e12 != null && e12.a()) {
                inputStream = context.getContentResolver().openInputStream(e12.j());
            }
            inputStream = null;
        }
        return inputStream;
    }

    public final OutputStream i(Context context, File destFile, Function1 function1) {
        Intrinsics.h(context, "context");
        Intrinsics.h(destFile, "destFile");
        try {
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        }
        if (c(destFile) || !j(destFile, context)) {
            return new FileOutputStream(destFile);
        }
        k1.a e12 = e(destFile, false, context);
        if (e12 != null && e12.a()) {
            Uri j11 = e12.j();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getOutputStream, file.uri = ");
            sb2.append(j11);
            if (function1 != null) {
                String uri = e12.j().toString();
                Intrinsics.g(uri, "toString(...)");
                function1.invoke(uri);
            }
            return context.getContentResolver().openOutputStream(e12.j());
        }
        return null;
    }

    public final boolean j(File file, Context c11) {
        Intrinsics.h(file, "file");
        Intrinsics.h(c11, "c");
        return f(file, c11) != null;
    }

    public final void k(String rootPath, final Function1 callback) {
        Intrinsics.h(rootPath, "rootPath");
        Intrinsics.h(callback, "callback");
        f60016d = new Function1() { // from class: com.transsnet.downloader.util.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l11;
                l11 = DocumentsUtils.l(Function1.this, (Uri) obj);
                return l11;
            }
        };
        DocumentsPermissionTransActivityImpl.INSTANCE.c(rootPath);
    }

    public final boolean m(Context context, String rootPath, Uri uri) {
        Intrinsics.h(rootPath, "rootPath");
        Intrinsics.h(uri, "uri");
        Intrinsics.e(context);
        k1.a h11 = k1.a.h(context, uri);
        if (h11 == null || !h11.a()) {
            Log.e(f60014b, "no write permission: " + rootPath);
            return false;
        }
        Log.e(f60014b, "saveTreeUri: rootPath = " + rootPath + "， uri = " + uri);
        com.transsion.baselib.report.launch.b.f43424a.b().putString(rootPath, uri.toString());
        return true;
    }
}
