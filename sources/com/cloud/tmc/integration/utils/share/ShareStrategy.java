package com.cloud.tmc.integration.utils.share;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.utils.share.config.IShareStrategy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J#\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J4\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/cloud/tmc/integration/utils/share/ShareStrategy;", "Lcom/cloud/tmc/integration/utils/share/config/IShareStrategy;", "()V", "bytes2HexString", "", "data", "", "doShare", "", "context", "Landroid/content/Context;", "shareParams", "Lcom/cloud/tmc/integration/utils/share/ShareParams;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/cloud/tmc/integration/utils/share/OnShareListener;", "getExternalDownloadAppPath", "getExternalDownloadPath", "getFileMD5", OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_FILE, "Ljava/io/File;", "getFileUriByCursor", "Landroid/net/Uri;", "(Landroid/content/Context;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileUriByProvider", "getSDCardPathByEnvironment", "handleShareChannels", "handleShareFile", "block", "Lkotlin/Function0;", "isSDCardEnableByEnvironment", "", "queryFileUriByCursor", "fileName", "absolutePath", "Companion", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ShareStrategy implements IShareStrategy {
    private static final String DIR_BYTEAPP = "MiniApp";
    private static final int MAX_QUERY_BY_CURSOR_COUNT = 3;
    private static final String TAG = "ShareStrategy";
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    private final String bytes2HexString(byte[] data) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.g(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb2 = new StringBuilder(data.length * 2);
        for (byte b11 : data) {
            sb2.append(charArray[(b11 >> 4) & 15]);
            sb2.append(charArray[b11 & 15]);
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "r.toString()");
        return sb3;
    }

    private final String getExternalDownloadAppPath() {
        if (!isSDCardEnableByEnvironment()) {
            return "";
        }
        String absolutePath = new File(getExternalDownloadPath(), "MiniApp").getAbsolutePath();
        Intrinsics.g(absolutePath, "{\n            File(getEx…P).absolutePath\n        }");
        return absolutePath;
    }

    private final String getExternalDownloadPath() {
        if (!isSDCardEnableByEnvironment()) {
            return "";
        }
        String absolutePath = new File(getSDCardPathByEnvironment(), Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        Intrinsics.g(absolutePath, "{\n            File(getSD…S).absolutePath\n        }");
        return absolutePath;
    }

    private final byte[] getFileMD5(File file) {
        if (file == null || !file.exists()) {
            return new byte[0];
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
                try {
                    do {
                    } while (digestInputStream.read(new byte[262144]) > 0);
                    byte[] digest = digestInputStream.getMessageDigest().digest();
                    Intrinsics.g(digest, "digest.digest()");
                    CloseableKt.a(digestInputStream, null);
                    CloseableKt.a(fileInputStream, null);
                    return digest;
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(fileInputStream, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            TmcLogger.e(TAG, "getFileMD5: ", th4);
            return new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b1 -> B:13:0x00b4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getFileUriByCursor(android.content.Context r17, java.io.File r18, kotlin.coroutines.Continuation<? super android.net.Uri> r19) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.share.ShareStrategy.getFileUriByCursor(android.content.Context, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Uri getFileUriByProvider(Context context, File file) {
        try {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, "getFileUri: ", th2);
            return null;
        }
    }

    private final String getSDCardPathByEnvironment() {
        return isSDCardEnableByEnvironment() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "";
    }

    private final void handleShareChannels(final Context context, final ShareParams shareParams, final OnShareListener listener) {
        handleShareFile(context, shareParams, listener, new Function0<Unit>() { // from class: com.cloud.tmc.integration.utils.share.ShareStrategy$handleShareChannels$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m695invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m695invoke() {
                if (ShareParams.this.getChannel() == 1) {
                    new ShareBySystem(context).share(ShareParams.this, listener);
                    return;
                }
                TmcLogger.d("ShareStrategy", "handleShareChannels: no channel");
                OnShareListener onShareListener = listener;
                if (onShareListener != null) {
                    onShareListener.onShare(ShareParams.this.getChannel(), 2);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleShareFile(android.content.Context r20, com.cloud.tmc.integration.utils.share.ShareParams r21, com.cloud.tmc.integration.utils.share.OnShareListener r22, final kotlin.jvm.functions.Function0<kotlin.Unit> r23) {
        /*
            r19 = this;
            r0 = r20
            r8 = r22
            r6 = r23
            java.lang.String r9 = "ShareStrategy"
            java.io.File r5 = r21.getShareFile()
            if (r5 == 0) goto Lb4
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            r3 = 1
            r4 = 0
            r10 = 2
            if (r1 < r2) goto L22
            java.lang.String[] r2 = new java.lang.String[r10]
            java.lang.String r7 = "android.permission.READ_MEDIA_IMAGES"
            r2[r4] = r7
            java.lang.String r4 = "android.permission.READ_MEDIA_VIDEO"
            r2[r3] = r4
            goto L28
        L22:
            java.lang.String[] r2 = new java.lang.String[r3]
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            r2[r4] = r3
        L28:
            int r3 = r2.length     // Catch: java.lang.Throwable -> L48
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)     // Catch: java.lang.Throwable -> L48
            java.lang.String[] r2 = (java.lang.String[]) r2     // Catch: java.lang.Throwable -> L48
            boolean r2 = com.cloud.tmc.integration.utils.share.ShareUtils.isGranted(r0, r2)     // Catch: java.lang.Throwable -> L48
            if (r2 != 0) goto L4f
            r2 = 34
            if (r1 >= r2) goto L4f
            java.lang.String r0 = "handleShareFile: has no write permission"
            com.cloud.tmc.kernel.log.TmcLogger.e(r9, r0)     // Catch: java.lang.Throwable -> L48
            if (r8 == 0) goto L4e
            int r0 = r21.getChannel()     // Catch: java.lang.Throwable -> L48
            r8.onShare(r0, r10)     // Catch: java.lang.Throwable -> L48
            goto L4e
        L48:
            r0 = move-exception
            r11 = r19
        L4b:
            r12 = r21
            goto La5
        L4e:
            return
        L4f:
            boolean r1 = r5.exists()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L9b
            boolean r1 = r21.isFileProvider()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L75
            r11 = r19
            android.net.Uri r0 = r11.getFileUriByProvider(r0, r5)     // Catch: java.lang.Throwable -> L73
            r12 = r21
            r12.setFileUri(r0)     // Catch: java.lang.Throwable -> L71
            android.os.Handler r0 = com.cloud.tmc.integration.utils.share.ShareStrategy.HANDLER     // Catch: java.lang.Throwable -> L71
            com.cloud.tmc.integration.utils.share.a r1 = new com.cloud.tmc.integration.utils.share.a     // Catch: java.lang.Throwable -> L71
            r1.<init>()     // Catch: java.lang.Throwable -> L71
            r0.post(r1)     // Catch: java.lang.Throwable -> L71
            return
        L71:
            r0 = move-exception
            goto La5
        L73:
            r0 = move-exception
            goto L4b
        L75:
            r11 = r19
            r12 = r21
            kotlinx.coroutines.i0 r1 = kotlinx.coroutines.y0.b()     // Catch: java.lang.Throwable -> L71
            kotlinx.coroutines.n0 r13 = kotlinx.coroutines.o0.a(r1)     // Catch: java.lang.Throwable -> L71
            com.cloud.tmc.integration.utils.share.ShareStrategy$handleShareFile$1$2 r16 = new com.cloud.tmc.integration.utils.share.ShareStrategy$handleShareFile$1$2     // Catch: java.lang.Throwable -> L71
            r7 = 0
            r1 = r16
            r2 = r21
            r3 = r19
            r4 = r20
            r6 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L71
            r17 = 3
            r18 = 0
            r14 = 0
            r15 = 0
            kotlinx.coroutines.i.d(r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L71
            return
        L9b:
            r11 = r19
            r12 = r21
            java.lang.String r0 = "handleShareFile: file is not exist"
            com.cloud.tmc.kernel.log.TmcLogger.e(r9, r0)     // Catch: java.lang.Throwable -> L71
            goto Laa
        La5:
            java.lang.String r1 = "handleShareFile: exception"
            com.cloud.tmc.kernel.log.TmcLogger.e(r9, r1, r0)
        Laa:
            if (r8 == 0) goto Lb3
            int r0 = r21.getChannel()
            r8.onShare(r0, r10)
        Lb3:
            return
        Lb4:
            r11 = r19
            android.os.Handler r0 = com.cloud.tmc.integration.utils.share.ShareStrategy.HANDLER
            com.cloud.tmc.integration.utils.share.b r1 = new com.cloud.tmc.integration.utils.share.b
            r1.<init>()
            r0.post(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.share.ShareStrategy.handleShareFile(android.content.Context, com.cloud.tmc.integration.utils.share.ShareParams, com.cloud.tmc.integration.utils.share.OnShareListener, kotlin.jvm.functions.Function0):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void handleShareFile$default(ShareStrategy shareStrategy, Context context, ShareParams shareParams, OnShareListener onShareListener, Function0 function0, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function0 = null;
        }
        shareStrategy.handleShareFile(context, shareParams, onShareListener, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleShareFile$lambda$1$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleShareFile$lambda$2(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final boolean isSDCardEnableByEnvironment() {
        return Intrinsics.c("mounted", Environment.getExternalStorageState());
    }

    private final Uri queryFileUriByCursor(Context context, String fileName, String absolutePath) {
        Uri contentUri = MediaStore.Files.getContentUri("external");
        Intrinsics.g(contentUri, "getContentUri(\"external\")");
        Cursor query = context.getContentResolver().query(contentUri, null, "_display_name=? AND _data=?", new String[]{fileName, absolutePath}, null);
        if (query == null || !query.moveToNext()) {
            if (query == null) {
                return null;
            }
            query.close();
            return null;
        }
        Uri withAppendedId = ContentUris.withAppendedId(contentUri, query.getLong(query.getColumnIndex("_id")));
        Intrinsics.g(withAppendedId, "withAppendedId(contentUri, id)");
        TmcLogger.d(TAG, "queryFileUriByCursor: uri: " + withAppendedId + " displayName: " + query.getString(query.getColumnIndex("_display_name")) + " path: " + query.getString(query.getColumnIndex("_data")));
        query.close();
        return withAppendedId;
    }

    @Override // com.cloud.tmc.integration.utils.share.config.IShareStrategy
    public void doShare(Context context, ShareParams shareParams, OnShareListener listener) {
        Intrinsics.h(context, "context");
        Intrinsics.h(shareParams, "shareParams");
        TmcLogger.d(TAG, "doShare: " + shareParams);
        handleShareChannels(context, shareParams, listener);
    }
}
