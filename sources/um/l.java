package um;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.view.c0;
import com.blankj.utilcode.util.a0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.transsion.member.MemberViewModel;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.member.bean.request.MemberInviteUserShareInfo;
import com.transsion.member.constants.TaskType;
import com.transsion.member.view.InviteUserView;
import com.transsion.memberapi.MemberTaskInviteRewards;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskItemInvite;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.web.share.WebShareDialog;
import com.transsnet.loginapi.ILoginApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class l extends BaseItemProvider {

    /* renamed from: e, reason: collision with root package name */
    private final Fragment f76978e;

    /* renamed from: f, reason: collision with root package name */
    private final MemberViewModel f76979f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f76980g;

    /* renamed from: h, reason: collision with root package name */
    private final ILoginApi f76981h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f76982i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f76983j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.activity.result.b f76984k;

    /* loaded from: classes6.dex */
    public static final class a implements InviteUserView.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InviteUserView f76986b;

        a(InviteUserView inviteUserView) {
            this.f76986b = inviteUserView;
        }

        @Override // com.transsion.member.view.InviteUserView.c
        public void a() {
            MemberViewModel S = l.this.S();
            Integer num = l.this.f76983j;
            S.U(num != null ? num.intValue() : 0, 15);
        }

        @Override // com.transsion.member.view.InviteUserView.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(InviteUserView.e holder, int i11, MemberTaskItemInvite data) {
            TextView textView;
            Intrinsics.h(holder, "holder");
            Intrinsics.h(data, "data");
            ImageView imageView = (ImageView) holder.itemView.findViewById(R$id.tag_iv);
            TextView textView2 = (TextView) holder.itemView.findViewById(R$id.member_reward);
            l lVar = l.this;
            InviteUserView inviteUserView = this.f76986b;
            textView2.setText("+" + data.getRewardAmount() + (data.getRewardType() == 1 ? "days" : "points"));
            if (data.getStatus() == 1 && lVar.f76980g) {
                View findViewById = holder.itemView.findViewById(R$id.member_invite_user_tv);
                if (findViewById != null) {
                    jg.c.g(findViewById);
                }
                View findViewById2 = holder.itemView.findViewById(R$id.member_invite_user_pb);
                if (findViewById2 != null) {
                    jg.c.k(findViewById2);
                }
            } else {
                View findViewById3 = holder.itemView.findViewById(R$id.member_invite_user_tv);
                if (findViewById3 != null) {
                    jg.c.k(findViewById3);
                }
                View findViewById4 = holder.itemView.findViewById(R$id.member_invite_user_pb);
                if (findViewById4 != null) {
                    jg.c.g(findViewById4);
                }
            }
            if (data.getStatus() == 0 && (textView = (TextView) holder.itemView.findViewById(R$id.member_invite_user_tv)) != null) {
                textView.setText(inviteUserView.getContext().getString(R$string.member_reward_friend_tips, Integer.valueOf(data.getFriendSeq())));
            }
            imageView.setImageResource(data.getRewardType() == 1 ? R$mipmap.ic_member_small : R$mipmap.ic_member_points);
        }

        @Override // com.transsion.member.view.InviteUserView.c
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int b(int i11, MemberTaskItemInvite data) {
            Intrinsics.h(data, "data");
            int status = data.getStatus();
            if (status != 0) {
                return status != 1 ? 1 : 2;
            }
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f76987a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f76987a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f76987a;
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
            this.f76987a.invoke(obj);
        }
    }

    public l(Fragment fragment, MemberViewModel viewModel) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(viewModel, "viewModel");
        this.f76978e = fragment;
        this.f76979f = viewModel;
        this.f76981h = (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
        androidx.activity.result.b registerForActivityResult = fragment.registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: um.d
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                l.V(l.this, (ActivityResult) obj);
            }
        });
        Intrinsics.g(registerForActivityResult, "registerForActivityResult(...)");
        this.f76984k = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(TextView textView, l lVar, MemberTaskItem memberTaskItem, View view) {
        if (com.transsion.baseui.util.c.f43558a.a(textView.getId(), 2000L)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "task_invite_user_share_dialog");
        ILoginApi iLoginApi = lVar.f76981h;
        boolean z10 = false;
        if (iLoginApi != null && iLoginApi.a()) {
            z10 = true;
        }
        linkedHashMap.put("is_login", String.valueOf(z10));
        Unit unit = Unit.f67184a;
        lVar.U(memberTaskItem, linkedHashMap);
        ILoginApi iLoginApi2 = lVar.f76981h;
        if (iLoginApi2 != null && iLoginApi2.a()) {
            lVar.f76982i = true;
            lVar.f76979f.V();
            return;
        }
        ILoginApi iLoginApi3 = lVar.f76981h;
        if (iLoginApi3 != null) {
            Context context = textView.getContext();
            Intrinsics.g(context, "getContext(...)");
            iLoginApi3.j(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit K(um.l r16, com.transsion.memberapi.MemberTaskItem r17, com.transsion.member.view.InviteUserView r18, android.widget.TextView r19, zm.d r20) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: um.l.K(um.l, com.transsion.memberapi.MemberTaskItem, com.transsion.member.view.InviteUserView, android.widget.TextView, zm.d):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(InviteUserView inviteUserView, l lVar, MemberTaskItem memberTaskItem, MemberTaskInviteRewards memberTaskInviteRewards) {
        List<MemberTaskItemInvite> list;
        if (!inviteUserView.getIsLoadMoreLoading()) {
            return Unit.f67184a;
        }
        if (memberTaskInviteRewards == null || (list = memberTaskInviteRewards.getList()) == null || list.isEmpty()) {
            inviteUserView.onLoadMoreCompleted(new ArrayList());
            inviteUserView.setLoadMoreEnable(false);
        } else {
            lVar.f76983j = Integer.valueOf(memberTaskInviteRewards.getLastId());
            List<MemberTaskItemInvite> list2 = memberTaskInviteRewards.getList();
            if (list2 == null || list2.isEmpty()) {
                inviteUserView.onLoadMoreCompleted(new ArrayList());
            } else {
                List<MemberTaskItemInvite> list3 = memberTaskInviteRewards.getList();
                if (list3 != null) {
                    List<MemberTaskItemInvite> list4 = list3;
                    if (list4.isEmpty()) {
                        inviteUserView.onLoadMoreCompleted(new ArrayList());
                    } else {
                        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
                        if (inviteList != null) {
                            inviteList.addAll(list4);
                        }
                        inviteUserView.onLoadMoreCompleted(list3);
                    }
                }
            }
            if (memberTaskInviteRewards.getLastId() == 0) {
                inviteUserView.setLoadMoreEnable(false);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(final l lVar, Map map) {
        String str;
        MemberInviteUserShareInfo memberInviteUserShareInfo;
        if (lVar.f76982i) {
            if (map.isEmpty()) {
                String string = lVar.k().getString(com.tn.lib.widget.R$string.load_failed);
                Intrinsics.g(string, "getString(...)");
                lVar.W(string);
                return Unit.f67184a;
            }
            JSONObject jSONObject = new JSONObject();
            Intrinsics.e(map);
            loop0: while (true) {
                str = "";
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    MemberInviteUserShareInfo memberInviteUserShareInfo2 = (MemberInviteUserShareInfo) entry.getValue();
                    String desc = memberInviteUserShareInfo2 != null ? memberInviteUserShareInfo2.getDesc() : null;
                    MemberInviteUserShareInfo memberInviteUserShareInfo3 = (MemberInviteUserShareInfo) entry.getValue();
                    jSONObject.put(str2, desc + ", " + (memberInviteUserShareInfo3 != null ? memberInviteUserShareInfo3.getUrl() : null));
                    if (str.length() != 0 || ((memberInviteUserShareInfo = (MemberInviteUserShareInfo) entry.getValue()) != null && (str = memberInviteUserShareInfo.getTitle()) != null)) {
                    }
                }
                break loop0;
            }
            jSONObject.put("H5Source", "fissionNative");
            if (str.length() == 0) {
                str = lVar.k().getString(R$string.member_invite_user_share_title);
                Intrinsics.g(str, "getString(...)");
            }
            jSONObject.put(CampaignEx.JSON_KEY_TITLE, str);
            WebShareDialog.Companion companion = WebShareDialog.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.g(jSONObject2, "toString(...)");
            final WebShareDialog a11 = companion.a(jSONObject2);
            a11.r0(new Function3() { // from class: um.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit N;
                    N = l.N(WebShareDialog.this, lVar, (String) obj, (String) obj2, (String) obj3);
                    return N;
                }
            });
            a11.k0(lVar.k(), "WebShareDialog");
            lVar.f76982i = !lVar.f76982i;
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(WebShareDialog webShareDialog, l lVar, String packageName, String str, String txt) {
        Object m1185constructorimpl;
        Intrinsics.h(packageName, "packageName");
        Intrinsics.h(txt, "txt");
        if (packageName.length() == 0) {
            ClipData newPlainText = ClipData.newPlainText("MovieBox", txt);
            Context context = webShareDialog.getContext();
            ClipboardManager clipboardManager = (ClipboardManager) (context != null ? context.getSystemService("clipboard") : null);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.web.R$string.web_copied);
        } else {
            Intent Q = lVar.Q(webShareDialog.getContext(), txt, packageName, str);
            if (Q == null) {
                com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.web.R$string.web_app_not_exist);
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    lVar.f76984k.a(Q);
                    m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Result.m1184boximpl(m1185constructorimpl);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(InviteUserView inviteUserView, MemberTaskItem memberTaskItem, l lVar, int i11, int i12) {
        if (i12 == 2) {
            if (com.transsion.baseui.util.c.f43558a.a(inviteUserView.getId(), 2000L)) {
                return Unit.f67184a;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
                List<MemberTaskItemInvite> list = inviteList;
                if (list != null && !list.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("event_detail", "task_invite_user_claim_item");
                    linkedHashMap.put("index", String.valueOf(i11));
                    Unit unit = Unit.f67184a;
                    lVar.U(memberTaskItem, linkedHashMap);
                    MemberTaskItemInvite memberTaskItemInvite = inviteList.get(i11);
                    if (memberTaskItemInvite.getStatus() == 1) {
                        lVar.f76980g = true;
                        inviteUserView.notifyItemInviteUserStateChange(i11);
                        lVar.f76979f.X(i11, memberTaskItemInvite.getRewardId(), memberTaskItemInvite.getRewardAmount(), memberTaskItemInvite.getRewardType());
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(TextView textView, l lVar, MemberTaskItem memberTaskItem, View view) {
        if (com.transsion.baseui.util.c.f43558a.a(textView.getId(), 2000L)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "task_invite_user_claim_all");
        linkedHashMap.put("index", TmcConstants.COLD_OPEN_TYPE);
        Unit unit = Unit.f67184a;
        lVar.U(memberTaskItem, linkedHashMap);
        lVar.f76980g = true;
        MemberViewModel memberViewModel = lVar.f76979f;
        MemberTaskRewardInfo rewardInfo = memberTaskItem.getRewardInfo();
        memberViewModel.X(-1, "0", rewardInfo != null ? rewardInfo.getDuration() : 0, 1);
    }

    private final Intent Q(Context context, String str, String str2, String str3) {
        String R = R(str2, str3);
        if (R == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ShareConstant.SHARE_TYPE_TEXT);
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setPackage(R);
        return intent;
    }

    private final String R(String str, String str2) {
        if (str != null && com.transsion.baseui.util.a.f43556a.c(k(), str)) {
            return str;
        }
        if (str2 == null || !com.transsion.baseui.util.a.f43556a.c(k(), str2)) {
            return null;
        }
        return str2;
    }

    private final void T(MemberTaskItem memberTaskItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_browse");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        Object obj = null;
        if (inviteList != null) {
            Iterator<T> it = inviteList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MemberTaskItemInvite) next).getStatus() == 1) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemInvite) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        com.transsion.baselib.helper.a.f43316a.a("rewards_center", hashMap);
    }

    private final void U(MemberTaskItem memberTaskItem, Map map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_type", "task_click");
        hashMap.put("taskSubType", String.valueOf(memberTaskItem.getTaskSubType()));
        hashMap.put("rewardType", String.valueOf(memberTaskItem.getRewardType()));
        hashMap.put("rewardAmount", String.valueOf(memberTaskItem.getRewardAmount()));
        List<MemberTaskItemInvite> inviteList = memberTaskItem.getInviteList();
        Object obj = null;
        if (inviteList != null) {
            Iterator<T> it = inviteList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MemberTaskItemInvite) next).getStatus() == 1) {
                    obj = next;
                    break;
                }
            }
            obj = (MemberTaskItemInvite) obj;
        }
        hashMap.put("showClaim", String.valueOf(obj == null));
        hashMap.putAll(map);
        com.transsion.baselib.helper.a.f43316a.b("rewards_center", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(l lVar, ActivityResult activityResult) {
        Intrinsics.h(activityResult, "activityResult");
        try {
            int resultCode = activityResult.getResultCode();
            if (resultCode == -1) {
                com.tn.lib.widget.toast.core.h.f41533a.l(lVar.k().getString(R$string.share_success_tips));
            } else if (resultCode != 0) {
                com.tn.lib.widget.toast.core.h.f41533a.l(lVar.k().getString(R$string.share_failed_tips));
            } else {
                com.tn.lib.widget.toast.core.h.f41533a.l(lVar.k().getString(R$string.share_canceled_tips));
            }
        } catch (Exception unused) {
        }
    }

    private final void W(String str) {
        uh.b.f76876a.g(R$layout.claim_succeed_layout, str, (r13 & 4) != 0 ? 0 : 80, (r13 & 8) != 0 ? 0 : 0, (r13 & 16) != 0 ? 0 : a0.a(66.0f));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, final MemberTaskItem item) {
        Object m1185constructorimpl;
        String str;
        List arrayList;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        T(item);
        final InviteUserView inviteUserView = (InviteUserView) helper.getView(R$id.task_invite_user_view);
        List data = inviteUserView.getData();
        List<MemberTaskItemInvite> inviteList = item.getInviteList();
        if (data.containsAll(inviteList != null ? inviteList : new ArrayList<>())) {
            Integer num = this.f76983j;
            inviteUserView.setLoadMoreEnable(num == null || num.intValue() != 0);
        } else {
            List<MemberTaskItemInvite> inviteList2 = item.getInviteList();
            if (inviteList2 == null || (arrayList = CollectionsKt.R0(inviteList2)) == null) {
                arrayList = new ArrayList();
            }
            inviteUserView.setData(arrayList);
            this.f76983j = null;
            inviteUserView.setLoadMoreEnable(true);
        }
        inviteUserView.setDataViewBinder(new a(inviteUserView));
        inviteUserView.setItemClicker(new Function2() { // from class: um.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit O;
                O = l.O(InviteUserView.this, item, this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return O;
            }
        });
        final TextView textView = (TextView) helper.getView(R$id.claim_all_bt);
        MemberTaskRewardInfo rewardInfo = item.getRewardInfo();
        if ((rewardInfo != null ? rewardInfo.getDuration() : 0) == 0) {
            str = textView.getContext().getString(R$string.member_claim_all);
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                Context context = textView.getContext();
                int i11 = R$string.task_invite_user_view_get_premium_text;
                MemberTaskRewardInfo rewardInfo2 = item.getRewardInfo();
                m1185constructorimpl = Result.m1185constructorimpl(context.getString(i11, rewardInfo2 != null ? Integer.valueOf(rewardInfo2.getDuration()) : null));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            String str2 = (String) m1185constructorimpl;
            if (str2 == null) {
                MemberTaskRewardInfo rewardInfo3 = item.getRewardInfo();
                str = rewardInfo3 != null ? rewardInfo3.getDescription() : null;
                if (str == null) {
                    str = "";
                }
            } else {
                str = str2;
            }
        }
        textView.setText(str);
        MemberTaskRewardInfo rewardInfo4 = item.getRewardInfo();
        textView.setEnabled((rewardInfo4 != null ? rewardInfo4.getDuration() : 0) > 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: um.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.P(textView, this, item, view);
            }
        });
        final TextView textView2 = (TextView) helper.getView(R$id.invite_tips_bt);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: um.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.J(textView2, this, item, view);
            }
        });
        this.f76979f.M().j(this.f76978e.getViewLifecycleOwner(), new b(new Function1() { // from class: um.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K;
                K = l.K(l.this, item, inviteUserView, textView, (zm.d) obj);
                return K;
            }
        }));
        this.f76979f.B().j(this.f76978e.getViewLifecycleOwner(), new b(new Function1() { // from class: um.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L;
                L = l.L(InviteUserView.this, this, item, (MemberTaskInviteRewards) obj);
                return L;
            }
        }));
        this.f76979f.I().j(this.f76978e.getViewLifecycleOwner(), new b(new Function1() { // from class: um.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit M;
                M = l.M(l.this, (Map) obj);
                return M;
            }
        }));
    }

    public final MemberViewModel S() {
        return this.f76979f;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return TaskType.INVITE_USER.getValue();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_task_invite_user_container;
    }
}
