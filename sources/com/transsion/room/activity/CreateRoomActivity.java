package com.transsion.room.activity;

import ak.x;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.view.c0;
import be.g;
import bq.a;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.a0;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.publish.api.IPublishApi;
import com.transsion.room.R$drawable;
import com.transsion.room.R$string;
import com.transsion.room.activity.CreateRoomActivity;
import com.transsion.room.bean.CheckNameBean;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import nh.m;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001d\u00100\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00107R$\u0010H\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00107\u001a\u0004\bE\u0010F\"\u0004\bG\u0010\nR$\u0010L\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010\n¨\u0006N"}, d2 = {"Lcom/transsion/room/activity/CreateRoomActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lbq/a;", "<init>", "()V", "", "x0", "", "groupId", "w0", "(Ljava/lang/String;)V", "initView", "q0", "path", "F0", "s0", "", "isTranslucent", "()Z", "isStatusDark", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "v0", "()Lbq/a;", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "", "a", "I", "TITLE_MAX", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "DESC_MAX", "c", "Z", "nameExist", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "d", "Landroidx/activity/result/b;", "photoLaunch", "Lcom/transsion/publish/api/IPublishApi;", "e", "Lkotlin/Lazy;", "t0", "()Lcom/transsion/publish/api/IPublishApi;", "publishApi", "Lcom/transsion/room/viewmodel/d;", "f", "u0", "()Lcom/transsion/room/viewmodel/d;", "roomCreateModel", g.f16474b, "Ljava/lang/String;", "avatorUrl", "h", "bucket", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "i", "Lcom/transsion/moviedetailapi/bean/RoomItem;", "roomItem", j.f35620b, "Ljava/lang/Boolean;", "FROM_EDIT", CampaignEx.JSON_KEY_AD_K, "currentGroupId", "l", "getName", "()Ljava/lang/String;", "setName", "name", "m", "getDesc", "setDesc", CampaignEx.JSON_KEY_DESC, "n", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class CreateRoomActivity extends BaseActivity<a> {

    /* renamed from: o, reason: collision with root package name */
    private static final String f51398o = "field_from";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean nameExist;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b photoLaunch;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoomItem roomItem;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String currentGroupId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String name;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String desc;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int TITLE_MAX = 50;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int DESC_MAX = 1000;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy publishApi = LazyKt.b(new Function0() { // from class: zp.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IPublishApi D0;
            D0 = CreateRoomActivity.D0();
            return D0;
        }
    });

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy roomCreateModel = LazyKt.b(new Function0() { // from class: zp.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            com.transsion.room.viewmodel.d E0;
            E0 = CreateRoomActivity.E0();
            return E0;
        }
    });

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String avatorUrl = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String bucket = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Boolean FROM_EDIT = Boolean.FALSE;

    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CreateRoomActivity.this.q0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Integer valueOf = editable != null ? Integer.valueOf(editable.length()) : null;
            if (valueOf == null || valueOf.intValue() < CreateRoomActivity.this.DESC_MAX) {
                return;
            }
            h.f41533a.l(CreateRoomActivity.this.getString(R$string.str_community_desc_limit));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class d implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f51414a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f51414a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f51414a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f51414a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements cw.a {
        e() {
        }

        @Override // cw.a
        public void a(String localFilePath, long j11, long j12) {
            Intrinsics.h(localFilePath, "localFilePath");
        }

        @Override // cw.a
        public void b(String localFilePath, String url, String bucket) {
            Intrinsics.h(localFilePath, "localFilePath");
            Intrinsics.h(url, "url");
            Intrinsics.h(bucket, "bucket");
            CreateRoomActivity.this.avatorUrl = url;
            CreateRoomActivity.this.bucket = bucket;
            CreateRoomActivity.this.q0();
        }

        @Override // cw.a
        public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
            a.C0856a.g(lg.a.f68962a, "uploadKey: " + str + "; clientMessage:" + str2 + "; serviceMessage: " + str3, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void A0(CreateRoomActivity createRoomActivity, View view) {
        if (!com.transsion.baseui.util.c.f43558a.a(view.getId(), 2000L) && ((bq.a) createRoomActivity.getMViewBinding()).f16794f.isEnabled()) {
            Editable text = ((bq.a) createRoomActivity.getMViewBinding()).f16791c.getText();
            createRoomActivity.name = String.valueOf(text != null ? StringsKt.n1(text) : null);
            Editable text2 = ((bq.a) createRoomActivity.getMViewBinding()).f16790b.getText();
            createRoomActivity.desc = String.valueOf(text2 != null ? StringsKt.n1(text2) : null);
            if (!m.f70597a.e()) {
                h.f41533a.l(createRoomActivity.getString(com.tn.lib.widget.R$string.no_network_toast));
                return;
            }
            String str = createRoomActivity.name;
            if (str != null) {
                createRoomActivity.u0().e(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(CreateRoomActivity createRoomActivity, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() != -1) {
            a.C0856a.f(lg.a.f68962a, "photoLaunch", "fail", false, 4, null);
            return;
        }
        Intent data = it.getData();
        String stringExtra = data != null ? data.getStringExtra("clip_result") : null;
        a.C0856a.f(lg.a.f68962a, "photoLaunch", "result:" + stringExtra, false, 4, null);
        if (stringExtra != null) {
            createRoomActivity.F0(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(CreateRoomActivity createRoomActivity, View view) {
        Intent h11;
        androidx.activity.result.b bVar;
        IPublishApi t02 = createRoomActivity.t0();
        if (t02 == null || (h11 = t02.h(createRoomActivity)) == null || (bVar = createRoomActivity.photoLaunch) == null) {
            return;
        }
        bVar.a(h11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPublishApi D0() {
        return (IPublishApi) TheRouter.d(IPublishApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.room.viewmodel.d E0() {
        return new com.transsion.room.viewmodel.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F0(String path) {
        f.b c11 = f.f62005a.m(this).g(path).i(R$drawable.ic_avatar_default).m(a0.a(96.0f)).c(a0.a(96.0f));
        ShapeableImageView ivAvatar = ((bq.a) getMViewBinding()).f16792d;
        Intrinsics.g(ivAvatar, "ivAvatar");
        c11.d(ivAvatar);
        cw.c.f61054a.f(path, UploadFileType.OBJECT_NAME_IMAGE, true, new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String avatar;
        Bundle extras = getIntent().getExtras();
        RoomItem roomItem = extras != null ? (RoomItem) extras.getParcelable("field_key") : null;
        this.roomItem = roomItem;
        this.currentGroupId = roomItem != null ? roomItem.getGroupId() : null;
        RoomItem roomItem2 = this.roomItem;
        if (roomItem2 != null && (avatar = roomItem2.getAvatar()) != null) {
            f.b c11 = f.f62005a.m(this).g(avatar).i(R$drawable.ic_avatar_default).m(a0.a(96.0f)).c(a0.a(96.0f));
            ShapeableImageView ivAvatar = ((bq.a) getMViewBinding()).f16792d;
            Intrinsics.g(ivAvatar, "ivAvatar");
            c11.d(ivAvatar);
            this.avatorUrl = avatar;
        }
        AppCompatEditText appCompatEditText = ((bq.a) getMViewBinding()).f16791c;
        RoomItem roomItem3 = this.roomItem;
        appCompatEditText.setText(roomItem3 != null ? roomItem3.getName() : null);
        AppCompatEditText appCompatEditText2 = ((bq.a) getMViewBinding()).f16790b;
        RoomItem roomItem4 = this.roomItem;
        appCompatEditText2.setText(roomItem4 != null ? roomItem4.getDescription() : null);
        if (this.roomItem != null) {
            this.FROM_EDIT = Boolean.TRUE;
            ((bq.a) getMViewBinding()).f16794f.setEnabled(true);
        }
        this.photoLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: zp.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                CreateRoomActivity.B0(CreateRoomActivity.this, (ActivityResult) obj);
            }
        });
        ((bq.a) getMViewBinding()).f16792d.setOnClickListener(new View.OnClickListener() { // from class: zp.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomActivity.C0(CreateRoomActivity.this, view);
            }
        });
        ((bq.a) getMViewBinding()).f16791c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.TITLE_MAX)});
        ((bq.a) getMViewBinding()).f16790b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.DESC_MAX)});
        ((bq.a) getMViewBinding()).f16791c.addTextChangedListener(new b());
        ((bq.a) getMViewBinding()).f16790b.addTextChangedListener(new c());
        ((bq.a) getMViewBinding()).f16794f.setOnClickListener(new View.OnClickListener() { // from class: zp.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomActivity.A0(CreateRoomActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        ThreadUtils.k(new Runnable() { // from class: zp.h
            @Override // java.lang.Runnable
            public final void run() {
                CreateRoomActivity.r0(CreateRoomActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r0(CreateRoomActivity createRoomActivity) {
        Editable text = ((bq.a) createRoomActivity.getMViewBinding()).f16791c.getText();
        int length = String.valueOf(text != null ? StringsKt.n1(text) : null).length();
        if (length <= 0 || TextUtils.isEmpty(createRoomActivity.avatorUrl)) {
            ((bq.a) createRoomActivity.getMViewBinding()).f16794f.setEnabled(false);
            return;
        }
        ((bq.a) createRoomActivity.getMViewBinding()).f16794f.setEnabled(true);
        if (length >= createRoomActivity.TITLE_MAX) {
            h.f41533a.l(createRoomActivity.getString(R$string.str_community_title_limit));
        }
    }

    private final void s0() {
        if (!Intrinsics.c(this.FROM_EDIT, Boolean.TRUE)) {
            String str = this.name;
            if (str != null) {
                com.transsion.room.viewmodel.d u02 = u0();
                String valueOf = String.valueOf(this.avatorUrl);
                String str2 = this.desc;
                u02.g(str, valueOf, str2 != null ? str2 : "", this.bucket);
                return;
            }
            return;
        }
        RoomItem roomItem = this.roomItem;
        String groupId = roomItem != null ? roomItem.getGroupId() : null;
        this.currentGroupId = groupId;
        String str3 = this.name;
        if (str3 == null || groupId == null) {
            return;
        }
        com.transsion.room.viewmodel.d u03 = u0();
        String valueOf2 = String.valueOf(this.avatorUrl);
        String str4 = this.desc;
        u03.o(groupId, str3, valueOf2, str4 == null ? "" : str4, this.bucket);
    }

    private final IPublishApi t0() {
        return (IPublishApi) this.publishApi.getValue();
    }

    private final com.transsion.room.viewmodel.d u0() {
        return (com.transsion.room.viewmodel.d) this.roomCreateModel.getValue();
    }

    private final void w0(String groupId) {
        Navigator.x(TheRouter.c("/room/detail").K("id", groupId), this, null, 2, null);
    }

    private final void x0() {
        u0().j().j(this, new d(new Function1() { // from class: zp.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y02;
                y02 = CreateRoomActivity.y0(CreateRoomActivity.this, (RoomNet) obj);
                return y02;
            }
        }));
        u0().h().j(this, new d(new Function1() { // from class: zp.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit z02;
                z02 = CreateRoomActivity.z0(CreateRoomActivity.this, (CheckNameBean) obj);
                return z02;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(CreateRoomActivity createRoomActivity, RoomNet roomNet) {
        if (roomNet != null) {
            hj.b logViewConfig = createRoomActivity.getLogViewConfig();
            if (logViewConfig != null) {
                logViewConfig.k(true);
            }
            if (Intrinsics.c(roomNet.getGroupId(), "update")) {
                createRoomActivity.setResult(-1);
                createRoomActivity.finish();
            } else {
                String groupId = roomNet.getGroupId();
                if (groupId != null) {
                    createRoomActivity.w0(groupId);
                    createRoomActivity.setResult(-1);
                    createRoomActivity.finish();
                }
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(CreateRoomActivity createRoomActivity, CheckNameBean checkNameBean) {
        if (checkNameBean != null) {
            boolean isExist = checkNameBean.isExist();
            createRoomActivity.nameExist = isExist;
            if (!isExist || TextUtils.equals(checkNameBean.getGroupId(), createRoomActivity.currentGroupId)) {
                createRoomActivity.s0();
            } else {
                uh.b.f76876a.e(createRoomActivity.getString(R$string.str_rooms_duplicate));
            }
        }
        return Unit.f67184a;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !x.f733a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public hj.b newLogViewConfig() {
        return new hj.b("createaroom", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NestedScrollView root = ((bq.a) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.e(root);
        initView();
        x0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public bq.a getViewBinding() {
        bq.a c11 = bq.a.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
