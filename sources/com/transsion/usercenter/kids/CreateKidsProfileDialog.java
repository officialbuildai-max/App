package com.transsion.usercenter.kids;

import ak.o;
import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import be.g;
import com.blankj.utilcode.util.KeyboardUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.noober.background.view.BLTextView;
import com.tn.lib.dialog.BaseDialog;
import com.transsion.baselib.kids.KidsAccountManager;
import com.transsion.baselib.kids.KidsProfile;
import com.transsion.usercenter.R$drawable;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.kids.AccountSwitchDialog;
import com.transsion.usercenter.kids.CreateKidsProfileDialog;
import com.transsion.usercenter.kids.PinInputDialog;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import hj.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/transsion/usercenter/kids/CreateKidsProfileDialog;", "Lcom/tn/lib/dialog/BaseDialog;", "<init>", "()V", "", "n0", "initView", "", "enabled", "r0", "(Z)V", "", "moduleName", "p0", "(Ljava/lang/String;)V", "q0", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", TmcConstants.NAVIGATION_ON_START, "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "a", "Ljava/lang/String;", "pageName", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "showSwitchOnDone", "c", "recordDismissOnClose", "d", "autoShowSoftInput", "Landroid/widget/EditText;", "e", "Landroid/widget/EditText;", "etProfileName", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivClose", "Lcom/noober/background/view/BLTextView;", g.f16474b, "Lcom/noober/background/view/BLTextView;", "tvCreate", "h", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class CreateKidsProfileDialog extends BaseDialog {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: b */
    private boolean showSwitchOnDone;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean recordDismissOnClose;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean autoShowSoftInput;

    /* renamed from: e, reason: from kotlin metadata */
    private EditText etProfileName;

    /* renamed from: f, reason: from kotlin metadata */
    private ImageView ivClose;

    /* renamed from: g */
    private BLTextView tvCreate;

    /* renamed from: com.transsion.usercenter.kids.CreateKidsProfileDialog$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CreateKidsProfileDialog b(Companion companion, boolean z10, boolean z11, boolean z12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z10 = true;
            }
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                z12 = true;
            }
            return companion.a(z10, z11, z12);
        }

        public final CreateKidsProfileDialog a(boolean z10, boolean z11, boolean z12) {
            CreateKidsProfileDialog createKidsProfileDialog = new CreateKidsProfileDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean("arg_show_switch_on_done", z10);
            bundle.putBoolean("arg_record_dismiss_on_close", z11);
            bundle.putBoolean("arg_auto_show_soft_input", z12);
            createKidsProfileDialog.setArguments(bundle);
            return createKidsProfileDialog;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CreateKidsProfileDialog.this.r0(!(editable == null || editable.length() == 0));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public CreateKidsProfileDialog() {
        super(R$layout.dialog_create_kids_profile);
        this.pageName = "";
        this.showSwitchOnDone = true;
        this.autoShowSoftInput = true;
    }

    public static final void h0(CreateKidsProfileDialog createKidsProfileDialog, View view) {
        Editable text;
        String obj;
        String obj2;
        EditText editText = createKidsProfileDialog.etProfileName;
        if (editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null || (obj2 = StringsKt.n1(obj).toString()) == null || obj2.length() == 0) {
            return;
        }
        createKidsProfileDialog.p0("create");
        final String c11 = o.f721a.c();
        final KidsProfile kidsProfile = new KidsProfile(c11, obj2, R$drawable.ic_kids_avatar, null, null, null, null, null, null, 504, null);
        KidsAccountManager.f43340a.m(kidsProfile, true);
        final FragmentActivity requireActivity = createKidsProfileDialog.requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        final FragmentManager parentFragmentManager = createKidsProfileDialog.getParentFragmentManager();
        Intrinsics.g(parentFragmentManager, "getParentFragmentManager(...)");
        EditText editText2 = createKidsProfileDialog.etProfileName;
        if (editText2 != null) {
            KeyboardUtils.e(editText2);
        }
        createKidsProfileDialog.dismissAllowingStateLoss();
        final Function0 function0 = createKidsProfileDialog.showSwitchOnDone ? new Function0() { // from class: pw.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit i02;
                i02 = CreateKidsProfileDialog.i0(c11, requireActivity);
                return i02;
            }
        } : new Function0() { // from class: pw.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j02;
                j02 = CreateKidsProfileDialog.j0(c11, parentFragmentManager);
                return j02;
            }
        };
        PinInputDialog.Companion.b(PinInputDialog.INSTANCE, false, new Function1() { // from class: pw.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                Unit k02;
                k02 = CreateKidsProfileDialog.k0(KidsProfile.this, function0, (String) obj3);
                return k02;
            }
        }, function0, 1, null).X(requireActivity, "PinInputDialog");
    }

    public static final Unit i0(String str, FragmentActivity fragmentActivity) {
        a.C0856a.f(a.f68962a, "CreateKidsProfileDialog", "kids account created, kidsId " + str + ", prepare AccountSwitchDialog.", false, 4, null);
        AccountSwitchDialog.Companion.b(AccountSwitchDialog.INSTANCE, false, 1, null).X(fragmentActivity, "AccountSwitchDialog");
        return Unit.f67184a;
    }

    private final void initView() {
        r0(false);
        EditText editText = this.etProfileName;
        if (editText != null) {
            editText.addTextChangedListener(new b());
        }
        EditText editText2 = this.etProfileName;
        if (editText2 != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: pw.k
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    CreateKidsProfileDialog.l0(view, z10);
                }
            });
        }
        ImageView imageView = this.ivClose;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: pw.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CreateKidsProfileDialog.m0(CreateKidsProfileDialog.this, view);
                }
            });
        }
        BLTextView bLTextView = this.tvCreate;
        if (bLTextView != null) {
            bLTextView.setOnClickListener(new View.OnClickListener() { // from class: pw.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CreateKidsProfileDialog.h0(CreateKidsProfileDialog.this, view);
                }
            });
        }
    }

    public static final Unit j0(String str, FragmentManager fragmentManager) {
        a.C0856a.f(a.f68962a, "CreateKidsProfileDialog", "kids account created, kidsId " + str + ", back to ManageProfilesFragment.", false, 4, null);
        fragmentManager.F1("result_kids_created", Bundle.EMPTY);
        return Unit.f67184a;
    }

    public static final Unit k0(KidsProfile kidsProfile, Function0 function0, String pin) {
        KidsProfile copy;
        Intrinsics.h(pin, "pin");
        copy = kidsProfile.copy((r20 & 1) != 0 ? kidsProfile.kidsId : null, (r20 & 2) != 0 ? kidsProfile.name : null, (r20 & 4) != 0 ? kidsProfile.avatarResId : 0, (r20 & 8) != 0 ? kidsProfile.gender : null, (r20 & 16) != 0 ? kidsProfile.birthday : null, (r20 & 32) != 0 ? kidsProfile.pinHash : pin, (r20 & 64) != 0 ? kidsProfile.avatarLocalPath : null, (r20 & 128) != 0 ? kidsProfile.favorites : null, (r20 & 256) != 0 ? kidsProfile.age : null);
        KidsAccountManager.f43340a.m(copy, true);
        function0.invoke();
        return Unit.f67184a;
    }

    public static final void l0(View view, boolean z10) {
        if (z10) {
            KeyboardUtils.i(view);
        }
    }

    public static final void m0(CreateKidsProfileDialog createKidsProfileDialog, View view) {
        if (createKidsProfileDialog.recordDismissOnClose) {
            KidsAccountManager.f43340a.k();
        }
        EditText editText = createKidsProfileDialog.etProfileName;
        if (editText != null) {
            KeyboardUtils.e(editText);
        }
        createKidsProfileDialog.dismissAllowingStateLoss();
        createKidsProfileDialog.p0("close");
    }

    private final void n0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setGravity(80);
        window.setSoftInputMode(this.autoShowSoftInput ? 20 : 18);
    }

    public static final void o0(CreateKidsProfileDialog createKidsProfileDialog) {
        if (!createKidsProfileDialog.isAdded() || createKidsProfileDialog.isStateSaved()) {
            return;
        }
        EditText editText = createKidsProfileDialog.etProfileName;
        if (editText != null) {
            editText.requestFocus();
        }
        EditText editText2 = createKidsProfileDialog.etProfileName;
        if (editText2 != null) {
            KeyboardUtils.i(editText2);
        }
    }

    private final void p0(String moduleName) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", "study_profile_create");
        hashMap.put("module_name", moduleName);
        i.f64628a.p(this.pageName, hashMap);
    }

    private final void q0() {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", "study_profile_create");
        i.f64628a.s(this.pageName, "dialog_show", hashMap);
    }

    public final void r0(boolean enabled) {
        BLTextView bLTextView = this.tvCreate;
        if (bLTextView != null) {
            bLTextView.setEnabled(enabled);
        }
        BLTextView bLTextView2 = this.tvCreate;
        if (bLTextView2 != null) {
            bLTextView2.setAlpha(enabled ? 1.0f : 0.35f);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.h(context, "context");
        super.onAttach(context);
        String simpleName = requireActivity().getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        this.pageName = simpleName;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(2, 0);
        Bundle arguments = getArguments();
        this.showSwitchOnDone = arguments != null ? arguments.getBoolean("arg_show_switch_on_done", true) : true;
        Bundle arguments2 = getArguments();
        this.recordDismissOnClose = arguments2 != null ? arguments2.getBoolean("arg_record_dismiss_on_close", false) : false;
        Bundle arguments3 = getArguments();
        this.autoShowSoftInput = arguments3 != null ? arguments3.getBoolean("arg_auto_show_soft_input", true) : true;
        q0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r32, Bundle savedInstanceState) {
        Intrinsics.h(r32, "view");
        super.onViewCreated(r32, savedInstanceState);
        this.etProfileName = (EditText) r32.findViewById(R$id.etProfileName);
        this.ivClose = (ImageView) r32.findViewById(R$id.ivClose);
        this.tvCreate = (BLTextView) r32.findViewById(R$id.tvCreate);
        n0();
        initView();
        if (this.autoShowSoftInput) {
            r32.postDelayed(new Runnable() { // from class: pw.j
                @Override // java.lang.Runnable
                public final void run() {
                    CreateKidsProfileDialog.o0(CreateKidsProfileDialog.this);
                }
            }, 200L);
        }
    }
}
