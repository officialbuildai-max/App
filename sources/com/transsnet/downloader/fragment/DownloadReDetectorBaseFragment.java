package com.transsnet.downloader.fragment;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baseui.R$string;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DocumentsUtils;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import g4.a;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0004¢\u0006\u0004\b \u0010\u0005R\"\u0010'\u001a\n \"*\u0004\u0018\u00010!0!8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u00104R\"\u00108\u001a\u00020\u001b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u00101\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u00104R\u0016\u0010:\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010$R\u0016\u0010<\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0016\u0010>\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00101R\u001b\u0010D\u001a\u00020?8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR$\u0010L\u001a\u0004\u0018\u00010E8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR4\u0010S\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020! \"*\n\u0012\u0004\u0012\u00020!\u0018\u00010N0N0M8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\"\u0010V\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010T0T0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010P¨\u0006W"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorBaseFragment;", "Lg4/a;", "T", "Lcom/transsion/baseui/fragment/PageStatusFragment;", "<init>", "()V", "", "v0", "x0", "w0", "y0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", TmcConstants.NAVIGATION_ON_START, "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "m0", "", "q0", "()I", "o0", "", "downloadSze", "", "u0", "(J)Z", "G0", "()Z", "F0", "", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "s0", "()Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "E0", "(Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;)V", "viewModel", "c", "Z", "isRequestPermissionSetting", "D0", "(Z)V", "d", "t0", "C0", "isRequestPermissionFirst", "e", "curSDRootPath", "f", "isDocumentTreePermissionChecked", be.g.f16474b, "isDocumentTreePermissionGranted", "Lcom/transsnet/downloader/manager/g;", "h", "Lkotlin/Lazy;", "p0", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Lmy/b;", "i", "Lmy/b;", "getCurPathInfo", "()Lmy/b;", "B0", "(Lmy/b;)V", "curPathInfo", "Landroidx/activity/result/b;", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "Landroidx/activity/result/b;", "r0", "()Landroidx/activity/result/b;", "requestStoragePermission", "Landroid/content/Intent;", CampaignEx.JSON_KEY_AD_K, "permissionDocumentBeforeQ", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public abstract class DownloadReDetectorBaseFragment<T extends g4.a> extends PageStatusFragment<T> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private DownloadResourcesDetectorViewModel viewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestPermissionSetting;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isDocumentTreePermissionChecked;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isDocumentTreePermissionGranted;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private my.b curPathInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final androidx.activity.result.b requestStoragePermission;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final androidx.activity.result.b permissionDocumentBeforeQ;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = getClass().getSimpleName();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestPermissionFirst = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String curSDRootPath = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadManager = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.r1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsnet.downloader.manager.g n02;
            n02 = DownloadReDetectorBaseFragment.n0();
            return n02;
        }
    });

    public DownloadReDetectorBaseFragment() {
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new f.h(), new androidx.activity.result.a() { // from class: com.transsnet.downloader.fragment.s1
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                DownloadReDetectorBaseFragment.A0(DownloadReDetectorBaseFragment.this, (Map) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.requestStoragePermission = registerForActivityResult;
        androidx.activity.result.b registerForActivityResult2 = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsnet.downloader.fragment.t1
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                DownloadReDetectorBaseFragment.z0(DownloadReDetectorBaseFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult2, "registerForActivityResult(...)");
        this.permissionDocumentBeforeQ = registerForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(DownloadReDetectorBaseFragment downloadReDetectorBaseFragment, Map permissions) {
        Intrinsics.h(permissions, "permissions");
        boolean z10 = true;
        for (Map.Entry entry : permissions.entrySet()) {
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = downloadReDetectorBaseFragment.TAG;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.f(c0856a, TAG, "registerForActivityResult Granted = " + entry.getValue(), false, 4, null);
            if (!((Boolean) entry.getValue()).booleanValue()) {
                z10 = false;
            }
        }
        if (z10) {
            a.C0856a c0856a2 = lg.a.f68962a;
            String TAG2 = downloadReDetectorBaseFragment.TAG;
            Intrinsics.g(TAG2, "TAG");
            a.C0856a.f(c0856a2, TAG2, "授权成功", false, 4, null);
            downloadReDetectorBaseFragment.x0();
            return;
        }
        a.C0856a c0856a3 = lg.a.f68962a;
        String TAG3 = downloadReDetectorBaseFragment.TAG;
        Intrinsics.g(TAG3, "TAG");
        a.C0856a.f(c0856a3, TAG3, "授权失败", false, 4, null);
        downloadReDetectorBaseFragment.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g n0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(DownloadReDetectorBaseFragment downloadReDetectorBaseFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() == -1) {
            if (it.getData() != null) {
                Intent data = it.getData();
                Intrinsics.e(data);
                if (data.getData() != null) {
                    a.C0856a c0856a = lg.a.f68962a;
                    String TAG = downloadReDetectorBaseFragment.TAG;
                    Intrinsics.g(TAG, "TAG");
                    Intent data2 = it.getData();
                    Intrinsics.e(data2);
                    a.C0856a.f(c0856a, TAG, "onStoragePermissionGranted------- uri = " + data2.getData(), false, 4, null);
                    DocumentsUtils documentsUtils = DocumentsUtils.f60013a;
                    Application a11 = Utils.a();
                    String str = downloadReDetectorBaseFragment.curSDRootPath;
                    Intent data3 = it.getData();
                    Intrinsics.e(data3);
                    Uri data4 = data3.getData();
                    Intrinsics.e(data4);
                    documentsUtils.m(a11, str, data4);
                    FragmentActivity requireActivity = downloadReDetectorBaseFragment.requireActivity();
                    String packageName = downloadReDetectorBaseFragment.requireActivity().getPackageName();
                    Intent data5 = it.getData();
                    Intrinsics.e(data5);
                    Uri data6 = data5.getData();
                    Intrinsics.e(data6);
                    requireActivity.grantUriPermission(packageName, data6, 3);
                    ContentResolver contentResolver = downloadReDetectorBaseFragment.requireActivity().getContentResolver();
                    Intent data7 = it.getData();
                    Intrinsics.e(data7);
                    Uri data8 = data7.getData();
                    Intrinsics.e(data8);
                    contentResolver.takePersistableUriPermission(data8, 3);
                    downloadReDetectorBaseFragment.isDocumentTreePermissionGranted = true;
                    downloadReDetectorBaseFragment.v0();
                    return;
                }
            }
            downloadReDetectorBaseFragment.isDocumentTreePermissionGranted = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B0(my.b bVar) {
        this.curPathInfo = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C0(boolean z10) {
        this.isRequestPermissionFirst = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D0(boolean z10) {
        this.isRequestPermissionSetting = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E0(DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel) {
        this.viewModel = downloadResourcesDetectorViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F0() {
        StorageVolume storageVolume;
        try {
            Intent intent = null;
            if (Build.VERSION.SDK_INT >= 24) {
                FragmentActivity activity = getActivity();
                Intrinsics.e(activity);
                storageVolume = ((StorageManager) activity.getSystemService(StorageManager.class)).getStorageVolume(new File(this.curSDRootPath));
                if (storageVolume != null) {
                    intent = storageVolume.createAccessIntent(null);
                }
            }
            if (intent == null) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            }
            this.permissionDocumentBeforeQ.a(intent);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean G0() {
        int i11 = Build.VERSION.SDK_INT;
        if (this.isDocumentTreePermissionChecked) {
            return !this.isDocumentTreePermissionGranted;
        }
        this.isDocumentTreePermissionChecked = true;
        if (i11 <= 28) {
            String str = "";
            for (my.f fVar : DownloadSDCardUtil.f60017a.b()) {
                if (fVar.c()) {
                    str = fVar.b();
                    this.curSDRootPath = str;
                }
            }
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.TAG;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.f(c0856a, TAG, "onStoragePermissionGranted，1  sdRootPath = " + str, false, 4, null);
            if (str.length() > 0) {
                DocumentsUtils documentsUtils = DocumentsUtils.f60013a;
                Application a11 = Utils.a();
                Intrinsics.g(a11, "getApp(...)");
                boolean d11 = documentsUtils.d(a11, str);
                String TAG2 = this.TAG;
                Intrinsics.g(TAG2, "TAG");
                a.C0856a.f(c0856a, TAG2, " check other permission, showOpenDocumentTree = " + d11, false, 4, null);
                if (d11) {
                    this.isDocumentTreePermissionGranted = false;
                    return true;
                }
            }
        }
        this.isDocumentTreePermissionGranted = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getTAG() {
        return this.TAG;
    }

    public void m0() {
        Fragment parentFragment = getParentFragment();
        DownloadReDetectorMainDialog downloadReDetectorMainDialog = parentFragment instanceof DownloadReDetectorMainDialog ? (DownloadReDetectorMainDialog) parentFragment : null;
        if (downloadReDetectorMainDialog != null) {
            downloadReDetectorMainDialog.dismissAllowingStateLoss();
        }
    }

    public int o0() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        int i12 = Build.VERSION.SDK_INT;
        return ((i11 - (i12 >= 35 ? com.blankj.utilcode.util.d.c() : 0)) - (i12 >= 35 ? com.blankj.utilcode.util.d.a() : 0)) - ((com.blankj.utilcode.util.y.e() * 9) / 16);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.isRequestPermissionFirst = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("download_root_path_permission_first", true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.isRequestPermissionSetting) {
            this.isRequestPermissionSetting = false;
            y0();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        Fragment parentFragment = getParentFragment();
        DownloadReDetectorMainDialog downloadReDetectorMainDialog = parentFragment instanceof DownloadReDetectorMainDialog ? (DownloadReDetectorMainDialog) parentFragment : null;
        if (downloadReDetectorMainDialog != null) {
            this.viewModel = (DownloadResourcesDetectorViewModel) new androidx.view.v0(downloadReDetectorMainDialog).a(DownloadResourcesDetectorViewModel.class);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.transsnet.downloader.manager.g p0() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    public int q0() {
        return o0() - com.blankj.utilcode.util.a0.a(116.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r0, reason: from getter */
    public final androidx.activity.result.b getRequestStoragePermission() {
        return this.requestStoragePermission;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s0, reason: from getter */
    public final DownloadResourcesDetectorViewModel getViewModel() {
        return this.viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t0, reason: from getter */
    public final boolean getIsRequestPermissionFirst() {
        return this.isRequestPermissionFirst;
    }

    public boolean u0(long downloadSze) {
        long a11;
        my.b bVar = this.curPathInfo;
        if (bVar == null) {
            DownloadEsHelper.a aVar = DownloadEsHelper.f59542m;
            aVar.a().i();
            String t11 = aVar.a().t();
            if (t11.length() == 0) {
                return false;
            }
            try {
                a11 = com.blankj.utilcode.util.n.j(t11);
            } catch (Throwable unused) {
                return false;
            }
        } else {
            Intrinsics.e(bVar);
            a11 = bVar.a();
        }
        Long y10 = p0().y();
        if (downloadSze + (y10 != null ? y10.longValue() : 0L) < a11) {
            return false;
        }
        uh.b.f76876a.d(R$string.insufficient_storage_available);
        lg.a.f68962a.o("--- 可用存储空间不足，释放空间并重试 ---", true);
        return true;
    }

    public void v0() {
    }

    public void w0() {
    }

    public void x0() {
    }

    public void y0() {
    }
}
