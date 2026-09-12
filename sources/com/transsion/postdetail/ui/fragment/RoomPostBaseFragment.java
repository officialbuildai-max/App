package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.LiveData;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetail.fragment.SubjectListFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.RoomTabItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.ninegridview.helper.FileHelper;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.NegativeFeedbackHelper;
import com.transsion.postdetail.ui.adapter.PostAdapterFrom;
import com.transsion.postdetail.ui.view.PostListLoadMoreView;
import com.transsion.postdetail.util.PostSaveHelper;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.postdetail.viewmodel.RoomPostViewModel;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.share.share.a;
import com.transsion.user.action.sync.event.CommentEvent;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.flow.event.sync.event.PublishEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dp.a;
import ep.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import lg.a;
import okhttp3.internal.http2.Settings;

@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00072\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J#\u0010\u001c\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u0015J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u0006J\u0017\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u0010\u0006J\u000f\u00105\u001a\u00020\u000eH\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u001aH\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u001aH\u0016¢\u0006\u0004\b9\u00108J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u00106J\u0015\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0007H\u0016¢\u0006\u0004\b?\u0010\u0006J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u0006J\u000f\u0010A\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u0010\u0006J\u001f\u0010D\u001a\u00020\u00072\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00072\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bJ\u0010IJ1\u0010Q\u001a\u00020\u00072\u0006\u0010L\u001a\u00020K2\u0010\u0010N\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0M2\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0011\u0010T\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010\u0006J\u000f\u0010W\u001a\u00020\u0007H\u0016¢\u0006\u0004\bW\u0010\u0006J\u0017\u0010Y\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u001aH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0007H\u0016¢\u0006\u0004\b[\u0010\u0006J\u000f\u0010]\u001a\u00020\\H\u0016¢\u0006\u0004\b]\u0010^J\u0019\u0010a\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\ba\u0010bJ!\u0010d\u001a\u00020\u00072\u0006\u0010c\u001a\u00020K2\b\u0010`\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u0007H\u0016¢\u0006\u0004\bf\u0010\u0006J\u0019\u0010h\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bh\u0010\u0015J\u0019\u0010i\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bi\u0010\u0015J\u0019\u0010j\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\bj\u0010\u0015J\u000f\u0010l\u001a\u00020kH&¢\u0006\u0004\bl\u0010mJ\u0019\u0010n\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\bn\u0010\u0015J\u000f\u0010o\u001a\u00020\u000eH&¢\u0006\u0004\bo\u00106J#\u0010r\u001a\u00020\u00072\b\b\u0002\u0010p\u001a\u00020\u001a2\b\b\u0002\u0010q\u001a\u00020\u001aH&¢\u0006\u0004\br\u0010sJ\u000f\u0010t\u001a\u00020\u000eH&¢\u0006\u0004\bt\u00106J\u000f\u0010u\u001a\u00020\u000eH&¢\u0006\u0004\bu\u00106J\u000f\u0010v\u001a\u00020\u001aH&¢\u0006\u0004\bv\u00108J\u000f\u0010w\u001a\u00020\u001aH&¢\u0006\u0004\bw\u00108J\u000f\u0010x\u001a\u00020KH&¢\u0006\u0004\bx\u0010yJ\u000f\u0010z\u001a\u00020\u001aH&¢\u0006\u0004\bz\u00108R\u0014\u0010{\u001a\u00020\u000e8\u0002X\u0083D¢\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010}\u001a\u00020\u000e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b}\u0010|\u001a\u0004\b~\u00106R+\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R,\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R,\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R(\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010|\u001a\u0005\b\u009c\u0001\u00106\"\u0005\b\u009d\u0001\u0010%R\u001e\u0010\u009e\u0001\u001a\u00020K8\u0004X\u0084D¢\u0006\u000f\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0005\b \u0001\u0010yR(\u0010¡\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010|\u001a\u0005\b¢\u0001\u00106\"\u0005\b£\u0001\u0010%R(\u0010¤\u0001\u001a\u00020K8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0006\b¤\u0001\u0010\u009f\u0001\u001a\u0005\b¥\u0001\u0010y\"\u0006\b¦\u0001\u0010§\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010«\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R(\u0010¯\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b¯\u0001\u0010|\u001a\u0005\b°\u0001\u00106\"\u0005\b±\u0001\u0010%R(\u0010²\u0001\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0015\n\u0005\b²\u0001\u0010|\u001a\u0005\b³\u0001\u00106\"\u0005\b´\u0001\u0010%R!\u0010µ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R,\u0010¸\u0001\u001a\u0005\u0018\u00010·\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001b\u0010Á\u0001\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R!\u0010È\u0001\u001a\u00030Ã\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R#\u0010Í\u0001\u001a\u0005\u0018\u00010É\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÊ\u0001\u0010Å\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R2\u0010Ó\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000e0Î\u0001j\t\u0012\u0004\u0012\u00020\u000e`Ï\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÐ\u0001\u0010Å\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010Ô\u0001\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010\u009f\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001¨\u0006×\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/RoomPostBaseFragment;", "Lcom/transsion/baseui/fragment/LazyFragment;", "Lso/s;", "Lep/b;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "<init>", "()V", "", "observePublish", "initExposureHelper", "observeComment", "observeDelete", "observeLike", "Lcom/tn/lib/net/bean/BaseDto;", "", "data", "updateDeletePost", "(Lcom/tn/lib/net/bean/BaseDto;)V", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "postItem", "onLikeClick", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;)V", "onCommentClick", "onDownloadClick", "requestPermission", "showSettingDialog", "", "navigateToComment", "openPostDetail", "(Lcom/transsion/moviedetailapi/bean/PostSubjectItem;Z)V", "onShareClick", "Lcom/transsion/baselib/db/download/DownloadBean;", "download", "saveBuiltInVideo", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "id", "removePost", "(Ljava/lang/String;)V", "localLogPause", "", "getPostExposurePercent", "()F", "initFeedVideo", "checkShowRefreshPopGuide", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Lso/s;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "lazyLoadData", "getPageStateLayoutTitle", "()Ljava/lang/String;", "isShowPageStateLayoutTitle", "()Z", "isAudioShowNoNetworkLayout", "getEmptyDescText", "Lak/q;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnNumNotExposureListener", "(Lak/q;)V", "initViewData", "initListener", "retryLoadData", "Lkotlin/Function0;", "resultCallback", "doRefresh", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "onResume", "onPause", "hidden", "onHiddenChanged", "(Z)V", "onDestroy", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "Lcom/transsion/moviedetailapi/bean/PostSubjectBean;", "bean", "updateData", "(Lcom/transsion/moviedetailapi/bean/PostSubjectBean;)V", RequestParameters.POSITION, "updateRoomCacheData", "(ILcom/transsion/moviedetailapi/bean/PostSubjectBean;)V", "checkToShowEmptyView", WebConstants.FIELD_ITEM, "openSubjectDetail", "openRoomDetail", "openUserCenter", "Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "postAdapterFrom", "()Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", "onItemHeaderClick", "onItemHeaderModuleName", "isFirstLoad", "isRefresh", "loadData", "(ZZ)V", "pageName", "subpageName", "isSwipeRefreshEnable", "isNeedInsertPublishPost", "tabIndex", "()I", "isStaggeredPost", "KEY_POST_EXPOSURE_PERCENT", "Ljava/lang/String;", "TAG", "getTAG", "Lcom/transsion/postdetail/ui/adapter/i;", "mAdapter", "Lcom/transsion/postdetail/ui/adapter/i;", "getMAdapter", "()Lcom/transsion/postdetail/ui/adapter/i;", "setMAdapter", "(Lcom/transsion/postdetail/ui/adapter/i;)V", "Lsj/b;", "mExposureHelper", "Lsj/b;", "getMExposureHelper", "()Lsj/b;", "setMExposureHelper", "(Lsj/b;)V", "Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;", "mViewModel", "Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;", "getMViewModel", "()Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;", "setMViewModel", "(Lcom/transsion/postdetail/viewmodel/RoomPostViewModel;)V", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "mDetailViewModel", "Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "getMDetailViewModel", "()Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;", "setMDetailViewModel", "(Lcom/transsion/postdetail/viewmodel/PostDetailViewModel;)V", "mPageFrom", "getMPageFrom", "setMPageFrom", "preLoadNum", "I", "getPreLoadNum", "mPage", "getMPage", "setMPage", "mPerPage", "getMPerPage", "setMPerPage", "(I)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "mSubject", "Lcom/transsion/moviedetailapi/bean/Subject;", "Lcom/transsion/moviedetailapi/bean/PostSubjectItem;", "Lcom/transsion/moviedetailapi/bean/Group;", "mGroup", "Lcom/transsion/moviedetailapi/bean/Group;", "mGroupId", "getMGroupId", "setMGroupId", "mParentTypeName", "getMParentTypeName", "setMParentTypeName", "mRefreshResultCallback", "Lkotlin/jvm/functions/Function0;", "Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "mTopTab", "Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "getMTopTab", "()Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "setMTopTab", "(Lcom/transsion/moviedetailapi/bean/RoomTabItem;)V", "Ldp/a;", "mFeedVideoManager", "Ldp/a;", "mLoadingView", "Landroid/view/View;", "Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi$delegate", "getMLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mExposureList$delegate", "getMExposureList", "()Ljava/util/HashSet;", "mExposureList", "mExposureCount", "mRefreshShown", "Z", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public abstract class RoomPostBaseFragment extends LazyFragment<so.s> implements ep.b, TRDialogListener {
    private com.transsion.postdetail.ui.adapter.i mAdapter;
    private PostDetailViewModel mDetailViewModel;
    private int mExposureCount;
    private sj.b mExposureHelper;
    private dp.a mFeedVideoManager;
    private Group mGroup;
    private String mGroupId;
    private View mLoadingView;
    private String mPage;
    private String mPageFrom;
    private String mParentTypeName;
    private Function0<Unit> mRefreshResultCallback;
    private boolean mRefreshShown;
    private Subject mSubject;
    private RoomTabItem mTopTab;
    private RoomPostViewModel mViewModel;
    private PostSubjectItem postItem;
    private final String KEY_POST_EXPOSURE_PERCENT = SubjectListFragment.KEY_POST_EXPOSURE_PERCENT;
    private final String TAG = "Post_" + getClass().getSimpleName();
    private final int preLoadNum = 2;
    private int mPerPage = 8;

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.z3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Handler mHandler_delegate$lambda$0;
            mHandler_delegate$lambda$0 = RoomPostBaseFragment.mHandler_delegate$lambda$0();
            return mHandler_delegate$lambda$0;
        }
    });

    /* renamed from: mLoginApi$delegate, reason: from kotlin metadata */
    private final Lazy mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.a4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi mLoginApi_delegate$lambda$1;
            mLoginApi_delegate$lambda$1 = RoomPostBaseFragment.mLoginApi_delegate$lambda$1();
            return mLoginApi_delegate$lambda$1;
        }
    });

    /* renamed from: mExposureList$delegate, reason: from kotlin metadata */
    private final Lazy mExposureList = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.b4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HashSet mExposureList_delegate$lambda$2;
            mExposureList_delegate$lambda$2 = RoomPostBaseFragment.mExposureList_delegate$lambda$2();
            return mExposureList_delegate$lambda$2;
        }
    });

    /* loaded from: classes6.dex */
    public static final class a implements sj.a {
        a() {
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            PostSubjectItem postSubjectItem;
            RoomPostBaseFragment roomPostBaseFragment = RoomPostBaseFragment.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                com.transsion.postdetail.ui.adapter.i mAdapter = roomPostBaseFragment.getMAdapter();
                if (mAdapter != null && (postSubjectItem = (PostSubjectItem) mAdapter.f0(i11)) != null) {
                    roomPostBaseFragment.checkShowRefreshPopGuide();
                    if (!CollectionsKt.b0(roomPostBaseFragment.getMExposureList(), postSubjectItem.getPostId())) {
                        String postId = postSubjectItem.getPostId();
                        if (postId != null) {
                            roomPostBaseFragment.getMExposureList().add(postId);
                        }
                        com.transsion.postdetail.helper.a.f48920a.w(roomPostBaseFragment.getMPageFrom(), roomPostBaseFragment.pageName(), roomPostBaseFragment.subpageName(), i11, j11, postSubjectItem, roomPostBaseFragment.getMGroupId());
                    }
                    if (roomPostBaseFragment instanceof RoomPostExploreFragment) {
                        ((RoomPostExploreFragment) roomPostBaseFragment).deleteCacheRoom(postSubjectItem);
                    }
                }
                Result.m1185constructorimpl(Unit.f67184a);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m1185constructorimpl(ResultKt.a(th2));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends DiffUtil.e {
        b() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(PostSubjectItem oldItem, PostSubjectItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getPostId(), newItem.getPostId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(PostSubjectItem oldItem, PostSubjectItem newItem) {
            Intrinsics.h(oldItem, "oldItem");
            Intrinsics.h(newItem, "newItem");
            return Intrinsics.c(oldItem.getPostId(), newItem.getPostId());
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements com.transsion.share.share.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareDialogFragment f49657a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PostSubjectItem f49658b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RoomPostBaseFragment f49659c;

        c(ShareDialogFragment shareDialogFragment, PostSubjectItem postSubjectItem, RoomPostBaseFragment roomPostBaseFragment) {
            this.f49657a = shareDialogFragment;
            this.f49658b = postSubjectItem;
            this.f49659c = roomPostBaseFragment;
        }

        @Override // com.transsion.share.share.a
        public void a(String id2, PostType postType) {
            Intrinsics.h(id2, "id");
            RoomPostViewModel mViewModel = this.f49659c.getMViewModel();
            if (mViewModel != null) {
                mViewModel.z(id2);
            }
        }

        @Override // com.transsion.share.share.a
        public void b(String str) {
            a.C0856a.f(lg.a.f68962a, this.f49659c.getTAG(), "id" + str, false, 4, null);
            this.f49659c.removePost(str);
        }

        @Override // com.transsion.share.share.a
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Subject subject;
            ResourceDetectors resourceDetector;
            String resourceLink;
            Media media;
            Cover cover;
            Integer size;
            Media media2;
            Cover cover2;
            String url2;
            String url3;
            String url4;
            Media media3;
            Intrinsics.h(url, "url");
            Intrinsics.h(fileName, "fileName");
            Intrinsics.h(fileSize, "fileSize");
            Intrinsics.h(fileImage, "fileImage");
            if (com.transsion.baseui.util.c.f43558a.a(this.f49657a.getId(), 500L)) {
                return;
            }
            PostSubjectItem postSubjectItem = this.f49658b;
            Video a11 = com.transsion.postdetail.util.u.a((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getVideo());
            PostSubjectItem postSubjectItem2 = this.f49658b;
            String title = postSubjectItem2 != null ? postSubjectItem2.getTitle() : null;
            if (TextUtils.isEmpty(title)) {
                PostSubjectItem postSubjectItem3 = this.f49658b;
                title = postSubjectItem3 != null ? postSubjectItem3.getContent() : null;
            }
            String str = title;
            String str2 = (a11 == null || (url4 = a11.getUrl()) == null) ? "" : url4;
            String str3 = (a11 == null || (url3 = a11.getUrl()) == null) ? "" : url3;
            PostSubjectItem postSubjectItem4 = this.f49658b;
            String str4 = (postSubjectItem4 == null || (media2 = postSubjectItem4.getMedia()) == null || (cover2 = media2.getCover()) == null || (url2 = cover2.getUrl()) == null) ? "" : url2;
            Long valueOf = (a11 == null || (size = a11.getSize()) == null) ? null : Long.valueOf(size.intValue());
            PostSubjectItem postSubjectItem5 = this.f49658b;
            String postId = postSubjectItem5 != null ? postSubjectItem5.getPostId() : null;
            PostSubjectItem postSubjectItem6 = this.f49658b;
            DownloadBean downloadBean = new DownloadBean(str2, str3, str, str4, valueOf, postSubjectItem6 != null ? postSubjectItem6.getPostId() : null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, postId, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -134217792, -1, Settings.DEFAULT_INITIAL_WINDOW_SIZE, null);
            PostSubjectItem postSubjectItem7 = this.f49658b;
            downloadBean.setThumbnail((postSubjectItem7 == null || (media = postSubjectItem7.getMedia()) == null || (cover = media.getCover()) == null) ? null : cover.getThumbnail());
            PostSubjectItem postSubjectItem8 = this.f49658b;
            if (postSubjectItem8 == null || !postSubjectItem8.getBuiltIn()) {
                DownloadManagerApi a12 = DownloadManagerApi.f58521j.a();
                Context context = this.f49657a.getContext();
                Intrinsics.f(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                PostSubjectItem postSubjectItem9 = this.f49658b;
                String ops = postSubjectItem9 != null ? postSubjectItem9.getOps() : null;
                PostSubjectItem postSubjectItem10 = this.f49658b;
                a12.O(fragmentActivity, downloadBean, VideoFragment.PAGE_NAME, ops, (postSubjectItem10 == null || (subject = postSubjectItem10.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? "" : resourceLink, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
            } else {
                this.f49659c.saveBuiltInVideo(downloadBean);
            }
            com.transsion.postdetail.helper.a.j(com.transsion.postdetail.helper.a.f48920a, this.f49658b, this.f49659c.subpageName(), null, 4, null);
        }

        @Override // com.transsion.share.share.a
        public void d(String id2) {
            Intrinsics.h(id2, "id");
        }

        @Override // com.transsion.share.share.a
        public void e(String str) {
            a.C0650a.c(this, str);
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f49660a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f49660a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f49660a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f49660a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkShowRefreshPopGuide() {
        if (Intrinsics.c(this.mParentTypeName, "BOTTOM_TAB") && !this.mRefreshShown) {
            int i11 = this.mExposureCount + 1;
            this.mExposureCount = i11;
            if (i11 < 9) {
                return;
            }
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            boolean z10 = bVar.b().getBoolean("ROOM_POST_REFRESH_GUIDE", false);
            this.mRefreshShown = true;
            if (z10) {
                return;
            }
            a.C0856a.f(lg.a.f68962a, this.TAG, "--ShowRefreshPopGuide", false, 4, null);
            bVar.b().putBoolean("ROOM_POST_REFRESH_GUIDE", true);
            aq.f fVar = new aq.f();
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = aq.f.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, fVar, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<String> getMExposureList() {
        return (HashSet) this.mExposureList.getValue();
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    private final ILoginApi getMLoginApi() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    private final float getPostExposurePercent() {
        Float t11;
        ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), this.KEY_POST_EXPOSURE_PERCENT, false, 2, null);
        String value = d11 != null ? d11.getValue() : null;
        if (value == null || value.length() == 0 || (t11 = StringsKt.t(value)) == null) {
            return 0.6f;
        }
        return t11.floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initExposureHelper() {
        RecyclerView recyclerView;
        float postExposurePercent = getPostExposurePercent();
        a.C0856a.f(lg.a.f68962a, "PostList", "initExposureHelper, postExposurePercent:" + postExposurePercent, false, 4, null);
        sj.b bVar = new sj.b(postExposurePercent, new a(), false, 4, null);
        bVar.n(2);
        so.s sVar = (so.s) getMViewBinding();
        if (sVar != null && (recyclerView = sVar.f75827b) != null) {
            recyclerView.addOnScrollListener(bVar);
        }
        this.mExposureHelper = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initFeedVideo() {
        a.C0759a c0759a = dp.a.f61499h1;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        so.s sVar = (so.s) getMViewBinding();
        this.mFeedVideoManager = c0759a.a(requireContext, this, sVar != null ? sVar.f75827b : null, this.mAdapter, pageName(), subpageName(), getActivity() instanceof vl.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$12$lambda$11(RoomPostBaseFragment roomPostBaseFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        String str = null;
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        int id2 = view.getId();
        if (id2 == R$id.fl_cover || id2 == R$id.tv_room_name || id2 == R$id.iv_user_avatar || id2 == R$id.tv_user_name || id2 == R$id.tv_post_date) {
            roomPostBaseFragment.onItemHeaderClick(postSubjectItem);
            str = roomPostBaseFragment.onItemHeaderModuleName();
        } else {
            if (id2 == R$id.v_post_like) {
                str = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : false ? "dislike" : "like";
                roomPostBaseFragment.onLikeClick(postSubjectItem);
            } else if (id2 == R$id.tv_staggered_post_like) {
                str = postSubjectItem != null ? Intrinsics.c(postSubjectItem.getHasLike(), Boolean.TRUE) : false ? "dislike" : "like";
                roomPostBaseFragment.onLikeClick(postSubjectItem);
            } else if (id2 == R$id.v_post_comment) {
                roomPostBaseFragment.onCommentClick(postSubjectItem);
                str = "comment";
            } else if (id2 == R$id.clHotComment) {
                roomPostBaseFragment.onCommentClick(postSubjectItem);
                str = "hot_comment";
            } else if (id2 == R$id.v_post_share) {
                roomPostBaseFragment.onShareClick(postSubjectItem);
                str = "share";
            } else if (id2 == R$id.v_post_download) {
                roomPostBaseFragment.onDownloadClick(postSubjectItem);
                str = "download";
            } else if (id2 == R$id.cl_subject_content) {
                roomPostBaseFragment.openSubjectDetail(postSubjectItem);
                str = "subject";
            } else if (id2 == R$id.tv_room_tag) {
                roomPostBaseFragment.openRoomDetail(postSubjectItem);
                str = "group";
            } else if (id2 == R$id.refresh_more) {
                InterfaceC1015e parentFragment = roomPostBaseFragment.getParentFragment();
                if (parentFragment instanceof aq.d) {
                    ((aq.d) parentFragment).t();
                }
            }
        }
        if (postSubjectItem != null) {
            com.transsion.postdetail.helper.a.f48920a.y(roomPostBaseFragment.mPageFrom, roomPostBaseFragment.pageName(), roomPostBaseFragment.subpageName(), i11, str == null ? "" : str, postSubjectItem, roomPostBaseFragment.mGroupId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initViewData$lambda$12$lambda$6$lambda$5(RoomPostBaseFragment roomPostBaseFragment) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return Unit.f67184a;
        }
        if (roomPostBaseFragment.isSwipeRefreshEnable()) {
            so.s sVar = (so.s) roomPostBaseFragment.getMViewBinding();
            if (sVar != null && (swipeRefreshLayout = sVar.f75828c) != null) {
                swipeRefreshLayout.setRefreshing(true);
            }
            b.a.a(roomPostBaseFragment, null, 1, null);
        } else {
            InterfaceC1015e parentFragment = roomPostBaseFragment.getParentFragment();
            if (parentFragment instanceof aq.d) {
                ((aq.d) parentFragment).e(false);
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViewData$lambda$12$lambda$8(final RoomPostBaseFragment roomPostBaseFragment) {
        RecyclerView recyclerView;
        if (nh.m.f70597a.e()) {
            loadData$default(roomPostBaseFragment, false, false, 1, null);
            return;
        }
        so.s sVar = (so.s) roomPostBaseFragment.getMViewBinding();
        if (sVar == null || (recyclerView = sVar.f75827b) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.u3
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$8$lambda$7(RoomPostBaseFragment.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$12$lambda$8$lambda$7(RoomPostBaseFragment roomPostBaseFragment) {
        r6.f h02;
        com.transsion.postdetail.ui.adapter.i iVar = roomPostBaseFragment.mAdapter;
        if (iVar == null || (h02 = iVar.h0()) == null) {
            return;
        }
        h02.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewData$lambda$12$lambda$9(RoomPostBaseFragment roomPostBaseFragment, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        PostSubjectItem postSubjectItem = item instanceof PostSubjectItem ? (PostSubjectItem) item : null;
        if (postSubjectItem == null || postSubjectItem.isRoomCacheListStart() || postSubjectItem.isRoomCacheListEnd()) {
            return;
        }
        com.transsion.postdetail.helper.a.f48920a.y(roomPostBaseFragment.mPageFrom, roomPostBaseFragment.pageName(), roomPostBaseFragment.subpageName(), i11, WebConstants.FIELD_ITEM, postSubjectItem, roomPostBaseFragment.mGroupId);
        openPostDetail$default(roomPostBaseFragment, postSubjectItem, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewData$lambda$15(RoomPostBaseFragment roomPostBaseFragment, BaseDto baseDto) {
        roomPostBaseFragment.updateDeletePost(baseDto);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initViewData$lambda$17(final RoomPostBaseFragment roomPostBaseFragment, PostSubjectItem postSubjectItem) {
        a.C0856a.f(lg.a.f68962a, roomPostBaseFragment.TAG, roomPostBaseFragment.getClass().getSimpleName() + "--Publish get detail result,  id:" + (postSubjectItem != null ? postSubjectItem.getPostId() : null), false, 4, null);
        if (postSubjectItem == null) {
            return Unit.f67184a;
        }
        postSubjectItem.setDistanceStr("<1m");
        com.transsion.postdetail.ui.adapter.i iVar = roomPostBaseFragment.mAdapter;
        if (iVar != null) {
            iVar.n(0, postSubjectItem);
        }
        roomPostBaseFragment.getMHandler().post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.e4
            @Override // java.lang.Runnable
            public final void run() {
                RoomPostBaseFragment.initViewData$lambda$17$lambda$16(RoomPostBaseFragment.this);
            }
        });
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViewData$lambda$17$lambda$16(RoomPostBaseFragment roomPostBaseFragment) {
        RecyclerView recyclerView;
        so.s sVar = (so.s) roomPostBaseFragment.getMViewBinding();
        if (sVar == null || (recyclerView = sVar.f75827b) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    public static /* synthetic */ void loadData$default(RoomPostBaseFragment roomPostBaseFragment, boolean z10, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadData");
        }
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        roomPostBaseFragment.loadData(z10, z11);
    }

    private final void localLogPause() {
        sj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashSet mExposureList_delegate$lambda$2() {
        return new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mHandler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi mLoginApi_delegate$lambda$1() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    private final void observeComment() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.x3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observeComment$lambda$23;
                observeComment$lambda$23 = RoomPostBaseFragment.observeComment$lambda$23(RoomPostBaseFragment.this, (CommentEvent) obj);
                return observeComment$lambda$23;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = CommentEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeComment$lambda$23(RoomPostBaseFragment roomPostBaseFragment, CommentEvent value) {
        Stat stat;
        Object m1185constructorimpl;
        Long valueOf;
        List<Object> data;
        List<Object> data2;
        Intrinsics.h(value, "value");
        try {
            com.transsion.postdetail.ui.adapter.i iVar = roomPostBaseFragment.mAdapter;
            int i11 = -1;
            if (iVar != null && (data2 = iVar.getData()) != null) {
                Iterator<Object> it = data2.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), value.getSubjectId())) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
            }
            if (i11 >= 0) {
                com.transsion.postdetail.ui.adapter.i iVar2 = roomPostBaseFragment.mAdapter;
                PostSubjectItem postSubjectItem = (iVar2 == null || (data = iVar2.getData()) == null) ? null : (PostSubjectItem) data.get(i11);
                if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        if (value.getStatus()) {
                            Long commentCount = stat.getCommentCount();
                            valueOf = Long.valueOf((commentCount != null ? commentCount.longValue() : 0L) + 1);
                        } else {
                            Long commentCount2 = stat.getCommentCount();
                            valueOf = Long.valueOf((commentCount2 != null ? commentCount2.longValue() : 1L) - 1);
                        }
                        stat.setCommentCount(valueOf);
                        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                    }
                    Result.m1184boximpl(m1185constructorimpl);
                }
                com.transsion.postdetail.ui.adapter.i iVar3 = roomPostBaseFragment.mAdapter;
                if (iVar3 != null) {
                    iVar3.notifyItemChanged(i11);
                }
            }
        } catch (Exception e11) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail " + e11.getMessage(), false, 2, null);
        }
        return Unit.f67184a;
    }

    private final void observeDelete() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.g4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observeDelete$lambda$25;
                observeDelete$lambda$25 = RoomPostBaseFragment.observeDelete$lambda$25(RoomPostBaseFragment.this, (uy.b) obj);
                return observeDelete$lambda$25;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = uy.b.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeDelete$lambda$25(RoomPostBaseFragment roomPostBaseFragment, uy.b value) {
        com.transsion.postdetail.ui.adapter.i iVar;
        List<Object> data;
        Intrinsics.h(value, "value");
        try {
            com.transsion.postdetail.ui.adapter.i iVar2 = roomPostBaseFragment.mAdapter;
            int i11 = -1;
            if (iVar2 != null && (data = iVar2.getData()) != null) {
                Iterator<Object> it = data.iterator();
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), value.a())) {
                        i11 = i12;
                        break;
                    }
                    i12++;
                }
            }
            if (i11 >= 0 && (iVar = roomPostBaseFragment.mAdapter) != null) {
                iVar.G0(i11);
            }
            roomPostBaseFragment.checkToShowEmptyView();
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        return Unit.f67184a;
    }

    private final void observeLike() {
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.y3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observeLike$lambda$29;
                observeLike$lambda$29 = RoomPostBaseFragment.observeLike$lambda$29(RoomPostBaseFragment.this, (LikeEvent) obj);
                return observeLike$lambda$29;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeLike$lambda$29(RoomPostBaseFragment roomPostBaseFragment, LikeEvent value) {
        int i11;
        Stat stat;
        Object m1185constructorimpl;
        List<Object> data;
        List<Object> data2;
        int i12 = 1;
        Intrinsics.h(value, "value");
        try {
            com.transsion.postdetail.ui.adapter.i iVar = roomPostBaseFragment.mAdapter;
            if (iVar != null && (data2 = iVar.getData()) != null) {
                Iterator<Object> it = data2.iterator();
                i11 = 0;
                while (it.hasNext()) {
                    if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), value.getSubjectId())) {
                        break;
                    }
                    i11++;
                }
            }
            i11 = -1;
            if (i11 >= 0) {
                com.transsion.postdetail.ui.adapter.i iVar2 = roomPostBaseFragment.mAdapter;
                PostSubjectItem postSubjectItem = (iVar2 == null || (data = iVar2.getData()) == null) ? null : (PostSubjectItem) data.get(i11);
                if (postSubjectItem != null) {
                    postSubjectItem.setHasLike(Boolean.valueOf(value.getLike()));
                }
                if (postSubjectItem != null && (stat = postSubjectItem.getStat()) != null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Long likeCount = stat.getLikeCount();
                        long longValue = likeCount != null ? likeCount.longValue() : 0L;
                        if (!value.getLike()) {
                            i12 = -1;
                        }
                        stat.setLikeCount(Long.valueOf(longValue + i12));
                        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                    }
                    Result.m1184boximpl(m1185constructorimpl);
                }
                com.transsion.postdetail.ui.adapter.i iVar3 = roomPostBaseFragment.mAdapter;
                if (iVar3 != null) {
                    iVar3.notifyItemChanged(i11, Boolean.valueOf(value.getLike()));
                }
            }
        } catch (Exception unused) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail", false, 2, null);
        }
        return Unit.f67184a;
    }

    private final void observePublish() {
        if (isNeedInsertPublishPost()) {
            a.C0856a.f(lg.a.f68962a, this.TAG, getClass().getSimpleName() + "--observePublish", false, 4, null);
            Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.d4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit observePublish$lambda$18;
                    observePublish$lambda$18 = RoomPostBaseFragment.observePublish$lambda$18(RoomPostBaseFragment.this, (PublishEvent) obj);
                    return observePublish$lambda$18;
                }
            };
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = PublishEvent.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observePublish$lambda$18(RoomPostBaseFragment roomPostBaseFragment, PublishEvent value) {
        PostDetailViewModel postDetailViewModel;
        Intrinsics.h(value, "value");
        InterfaceC1015e parentFragment = roomPostBaseFragment.getParentFragment();
        if (!(parentFragment instanceof aq.d)) {
            return Unit.f67184a;
        }
        int A = ((aq.d) parentFragment).A();
        a.C0856a.f(lg.a.f68962a, roomPostBaseFragment.TAG, roomPostBaseFragment.getClass().getSimpleName() + "--publishevent curTab:" + A + ", fTab:" + roomPostBaseFragment.tabIndex(), false, 4, null);
        if (roomPostBaseFragment.tabIndex() == A && (postDetailViewModel = roomPostBaseFragment.mDetailViewModel) != null) {
            postDetailViewModel.x(value.getPostId());
        }
        return Unit.f67184a;
    }

    private final void onCommentClick(PostSubjectItem postItem) {
        openPostDetail(postItem, true);
    }

    private final void onDownloadClick(PostSubjectItem postItem) {
        this.postItem = postItem;
        if (Build.VERSION.SDK_INT >= 29) {
            PostSaveHelper.f50199a.e(postItem);
            return;
        }
        Context context = getContext();
        if (context == null) {
            context = Utils.a();
        }
        if (androidx.core.content.b.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Context context2 = getContext();
            if (context2 == null) {
                context2 = Utils.a();
            }
            if (androidx.core.content.b.checkSelfPermission(context2, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
                PostSaveHelper.f50199a.e(postItem);
                return;
            }
        }
        requestPermission();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onLikeClick(PostSubjectItem postItem) {
        int c11 = postItem != null ? Intrinsics.c(postItem.getHasLike(), Boolean.TRUE) : 0;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_tips);
            return;
        }
        RoomPostViewModel roomPostViewModel = this.mViewModel;
        if (roomPostViewModel != null) {
            roomPostViewModel.Z(postItem != null ? postItem.getPostId() : null, c11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void onShareClick(com.transsion.moviedetailapi.bean.PostSubjectItem r19) {
        /*
            r18 = this;
            r0 = r19
            com.transsnet.loginapi.ILoginApi r1 = r18.getMLoginApi()
            r2 = 0
            if (r1 == 0) goto Le
            com.transsnet.loginapi.bean.UserInfo r1 = r1.i()
            goto Lf
        Le:
            r1 = r2
        Lf:
            if (r1 == 0) goto L16
            java.lang.String r3 = r1.getUserId()
            goto L17
        L16:
            r3 = r2
        L17:
            if (r3 == 0) goto L34
            java.lang.String r1 = r1.getUserId()
            if (r0 == 0) goto L2a
            com.transsion.moviedetailapi.bean.User r3 = r19.getUser()
            if (r3 == 0) goto L2a
            java.lang.String r3 = r3.getUserId()
            goto L2b
        L2a:
            r3 = r2
        L2b:
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r3)
            if (r1 == 0) goto L34
            r1 = 1
        L32:
            r11 = r1
            goto L36
        L34:
            r1 = 0
            goto L32
        L36:
            com.transsion.share.share.ShareDialogFragment$a r3 = com.transsion.share.share.ShareDialogFragment.INSTANCE
            com.transsion.share.bean.PostType r4 = com.transsion.share.bean.PostType.POST_TYPE
            if (r0 == 0) goto L42
            java.lang.String r1 = r19.getPostId()
            r5 = r1
            goto L43
        L42:
            r5 = r2
        L43:
            if (r0 == 0) goto L51
            com.transsion.moviedetailapi.bean.User r1 = r19.getUser()
            if (r1 == 0) goto L51
            java.lang.String r1 = r1.getUserId()
            r6 = r1
            goto L52
        L51:
            r6 = r2
        L52:
            com.transsion.usercenterapi.ReportType r1 = com.transsion.usercenterapi.ReportType.POST
            java.lang.String r7 = r1.getValue()
            if (r0 == 0) goto L60
            java.lang.String r1 = r19.getTitle()
            r8 = r1
            goto L61
        L60:
            r8 = r2
        L61:
            android.content.Context r1 = r18.getContext()
            if (r1 == 0) goto L6d
            int r2 = com.transsion.postdetail.R$string.save_video
            java.lang.String r2 = r1.getString(r2)
        L6d:
            r15 = r2
            r16 = 1344(0x540, float:1.883E-42)
            r17 = 0
            java.lang.String r9 = ""
            r10 = 0
            r12 = 0
            java.lang.String r13 = "postdetail"
            r14 = 0
            com.transsion.share.share.ShareDialogFragment r1 = com.transsion.share.share.ShareDialogFragment.Companion.b(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$c r2 = new com.transsion.postdetail.ui.fragment.RoomPostBaseFragment$c
            r3 = r18
            r2.<init>(r1, r0, r3)
            r1.G0(r2)
            androidx.fragment.app.FragmentManager r0 = r18.getChildFragmentManager()
            java.lang.String r2 = "share"
            r1.show(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.RoomPostBaseFragment.onShareClick(com.transsion.moviedetailapi.bean.PostSubjectItem):void");
    }

    private final void openPostDetail(PostSubjectItem postItem, boolean navigateToComment) {
        if (postItem != null) {
            IPostDetailApi iPostDetailApi = (IPostDetailApi) TheRouter.d(IPostDetailApi.class, new Object[0]);
            if (iPostDetailApi != null) {
                iPostDetailApi.i(postItem);
            }
            Media media = postItem.getMedia();
            Navigator K = TheRouter.c(Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.VIDEO.getValue()) ? "/post/detailVideo" : "/post/detail").K(WebConstants.PAGE_FROM, pageName()).z("from_comment", navigateToComment).J("item_object", postItem).K("id", postItem.getPostId()).K("rec_ops", postItem.getOps()).K("item_type", postItem.getItemType());
            Media media2 = postItem.getMedia();
            Navigator.x(K.K("media_type", media2 != null ? media2.getMediaType() : null).z("is_build_in", postItem.getBuiltIn()), requireContext(), null, 2, null);
        }
    }

    static /* synthetic */ void openPostDetail$default(RoomPostBaseFragment roomPostBaseFragment, PostSubjectItem postSubjectItem, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPostDetail");
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        roomPostBaseFragment.openPostDetail(postSubjectItem, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removePost(String id2) {
        List<Object> data;
        com.transsion.postdetail.ui.adapter.i iVar;
        com.transsion.postdetail.ui.adapter.i iVar2 = this.mAdapter;
        if (iVar2 == null || (data = iVar2.getData()) == null) {
            return;
        }
        Iterator<Object> it = data.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), id2)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0 && (iVar = this.mAdapter) != null) {
            iVar.G0(i11);
        }
    }

    private final void requestPermission() {
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, FileHelper.f47736a.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveBuiltInVideo(DownloadBean download) {
        kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), null, null, new RoomPostBaseFragment$saveBuiltInVideo$1(download, null), 3, null);
    }

    private final void showSettingDialog() {
        String string = Utils.a().getString(com.transsion.ninegridview.R$string.permission_deny_down_tip, "\"" + Utils.a().getString(com.transsion.baseui.R$string.base_app_name) + "\"", "\"" + Utils.a().getString(com.transsion.ninegridview.R$string.system_settings) + "\"");
        Intrinsics.g(string, "getString(...)");
        TRDialog.a g11 = new TRDialog.a().g(string);
        String string2 = Utils.a().getString(com.transsion.ninegridview.R$string.cancel);
        Intrinsics.g(string2, "getString(...)");
        TRDialog.a e11 = g11.e(string2);
        String string3 = Utils.a().getString(com.transsion.ninegridview.R$string.system_settings);
        Intrinsics.g(string3, "getString(...)");
        e11.j(string3).f(this).a().show(getChildFragmentManager(), "settings");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateData$lambda$39(RoomPostBaseFragment roomPostBaseFragment) {
        dp.a aVar = roomPostBaseFragment.mFeedVideoManager;
        if (aVar != null) {
            aVar.a();
        }
    }

    private final void updateDeletePost(BaseDto<String> data) {
        Object m1185constructorimpl;
        List<Object> data2;
        com.transsion.postdetail.ui.adapter.i iVar;
        Unit unit = null;
        if (!Intrinsics.c(data != null ? data.getCode() : null, "0")) {
            uh.b.f76876a.e(getString(com.transsion.postdetail.R$string.delete_post_failed));
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.postdetail.ui.adapter.i iVar2 = this.mAdapter;
            if (iVar2 != null && (data2 = iVar2.getData()) != null) {
                Iterator<Object> it = data2.iterator();
                int i11 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i11 = -1;
                        break;
                    } else if (Intrinsics.c(((PostSubjectItem) it.next()).getPostId(), data.getData())) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0 && (iVar = this.mAdapter) != null) {
                    iVar.G0(i11);
                }
                unit = Unit.f67184a;
            }
            m1185constructorimpl = Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Result.m1184boximpl(m1185constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRoomCacheData$lambda$47(RoomPostBaseFragment roomPostBaseFragment) {
        dp.a aVar = roomPostBaseFragment.mFeedVideoManager;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void checkToShowEmptyView() {
        if (getContext() == null) {
            return;
        }
        if (nh.m.f70597a.e()) {
            com.transsion.postdetail.ui.adapter.i iVar = this.mAdapter;
            if (iVar != null) {
                iVar.Y0(getEmptyView(false));
                return;
            }
            return;
        }
        com.transsion.postdetail.ui.adapter.i iVar2 = this.mAdapter;
        if (iVar2 != null) {
            iVar2.Y0(getLocalNoNetworkView(false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ep.b
    public void doRefresh(Function0<Unit> resultCallback) {
        so.s sVar;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            so.s sVar2 = (so.s) getMViewBinding();
            if (sVar2 != null && (swipeRefreshLayout = sVar2.f75828c) != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
            if (resultCallback != null) {
                resultCallback.invoke();
                return;
            }
            return;
        }
        this.mRefreshResultCallback = resultCallback;
        this.mPage = null;
        com.transsion.postdetail.ui.adapter.i iVar = this.mAdapter;
        List<Object> data = iVar != null ? iVar.getData() : null;
        if (data != null && !data.isEmpty() && (sVar = (so.s) getMViewBinding()) != null && (recyclerView = sVar.f75827b) != null) {
            recyclerView.scrollToPosition(0);
        }
        loadData$default(this, false, false, 3, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getEmptyDescText() {
        String string = getString(com.transsion.usercenter.R$string.profile_not_content);
        Intrinsics.g(string, "getString(...)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View getLoadingView() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return new View(Utils.a());
        }
        if (this.mLoadingView == null) {
            this.mLoadingView = LayoutInflater.from(activity).inflate(R$layout.layout_room_post_loading, (ViewGroup) getFlStateView(), false);
        }
        return this.mLoadingView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.transsion.postdetail.ui.adapter.i getMAdapter() {
        return this.mAdapter;
    }

    protected final PostDetailViewModel getMDetailViewModel() {
        return this.mDetailViewModel;
    }

    protected final sj.b getMExposureHelper() {
        return this.mExposureHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getMGroupId() {
        return this.mGroupId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getMPage() {
        return this.mPage;
    }

    protected final String getMPageFrom() {
        return this.mPageFrom;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getMParentTypeName() {
        return this.mParentTypeName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMPerPage() {
        return this.mPerPage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RoomTabItem getMTopTab() {
        return this.mTopTab;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RoomPostViewModel getMViewModel() {
        return this.mViewModel;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    protected final int getPreLoadNum() {
        return this.preLoadNum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public so.s getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        so.s c11 = so.s.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        observeComment();
        observeDelete();
        observeLike();
        observePublish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        SwipeRefreshLayout swipeRefreshLayout;
        com.transsion.postdetail.ui.adapter.i iVar;
        LiveData A;
        androidx.view.b0 C;
        RecyclerView recyclerView;
        NpaLinearLayoutManager npaLinearLayoutManager;
        so.s sVar;
        RecyclerView recyclerView2;
        so.s sVar2;
        RecyclerView recyclerView3;
        SwipeRefreshLayout swipeRefreshLayout2;
        initExposureHelper();
        if (isSwipeRefreshEnable()) {
            so.s sVar3 = (so.s) getMViewBinding();
            if (sVar3 != null && (swipeRefreshLayout2 = sVar3.f75828c) != null) {
                swipeRefreshLayout2.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(swipeRefreshLayout2.getContext(), R$color.bg_01));
                swipeRefreshLayout2.setColorSchemeColors(androidx.core.content.b.getColor(swipeRefreshLayout2.getContext(), R$color.main_gradient_center), androidx.core.content.b.getColor(swipeRefreshLayout2.getContext(), R$color.main_gradient_start));
                swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.postdetail.ui.fragment.h4
                    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                    public final void a() {
                        b.a.a(RoomPostBaseFragment.this, null, 1, null);
                    }
                });
            }
        } else {
            so.s sVar4 = (so.s) getMViewBinding();
            if (sVar4 != null && (swipeRefreshLayout = sVar4.f75828c) != null) {
                swipeRefreshLayout.setEnabled(false);
            }
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        PostAdapterFrom postAdapterFrom = postAdapterFrom();
        sj.b bVar = this.mExposureHelper;
        String pageName = pageName();
        String str = this.mPageFrom;
        androidx.view.u viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        com.transsion.postdetail.ui.adapter.i iVar2 = new com.transsion.postdetail.ui.adapter.i(requireContext, postAdapterFrom, bVar, pageName, str, androidx.view.v.a(viewLifecycleOwner));
        iVar2.h0().z(true);
        iVar2.h0().y(true);
        iVar2.h0().E(this.preLoadNum);
        r6.f h02 = iVar2.h0();
        PostListLoadMoreView postListLoadMoreView = new PostListLoadMoreView();
        postListLoadMoreView.setOnFailClickCallback(new Function0() { // from class: com.transsion.postdetail.ui.fragment.i4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit initViewData$lambda$12$lambda$6$lambda$5;
                initViewData$lambda$12$lambda$6$lambda$5 = RoomPostBaseFragment.initViewData$lambda$12$lambda$6$lambda$5(RoomPostBaseFragment.this);
                return initViewData$lambda$12$lambda$6$lambda$5;
            }
        });
        h02.C(postListLoadMoreView);
        iVar2.h0().D(new p6.f() { // from class: com.transsion.postdetail.ui.fragment.j4
            @Override // p6.f
            public final void a() {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$8(RoomPostBaseFragment.this);
            }
        });
        iVar2.R0(new b());
        iVar2.w1(new p6.d() { // from class: com.transsion.postdetail.ui.fragment.k4
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$9(RoomPostBaseFragment.this, baseQuickAdapter, view, i11);
            }
        });
        iVar2.l(R$id.fl_cover, R$id.tv_room_name, R$id.tv_post_date, R$id.v_post_like, R$id.v_post_comment, R$id.v_post_share, R$id.v_post_download, R$id.cl_subject_content, R$id.tv_room_tag, R$id.clHotComment, R$id.tv_staggered_post_like, R$id.iv_user_avatar, R$id.tv_user_name, R$id.refresh_more, R$id.ivNegativeFeedback);
        iVar2.s1(new p6.b() { // from class: com.transsion.postdetail.ui.fragment.l4
            @Override // p6.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomPostBaseFragment.initViewData$lambda$12$lambda$11(RoomPostBaseFragment.this, baseQuickAdapter, view, i11);
            }
        });
        this.mAdapter = iVar2;
        so.s sVar5 = (so.s) getMViewBinding();
        if (sVar5 != null && (recyclerView = sVar5.f75827b) != null) {
            if (isStaggeredPost()) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
                staggeredGridLayoutManager.f0(2);
                npaLinearLayoutManager = staggeredGridLayoutManager;
            } else {
                npaLinearLayoutManager = new NpaLinearLayoutManager(recyclerView.getContext());
            }
            recyclerView.setLayoutManager(npaLinearLayoutManager);
            if (isStaggeredPost() && (sVar = (so.s) getMViewBinding()) != null && (recyclerView2 = sVar.f75827b) != null && recyclerView2.getItemDecorationCount() == 0 && (sVar2 = (so.s) getMViewBinding()) != null && (recyclerView3 = sVar2.f75827b) != null) {
                recyclerView3.addItemDecoration(new ig.g(com.blankj.utilcode.util.a0.a(6.0f), true));
            }
            recyclerView.setAdapter(this.mAdapter);
        }
        RoomPostViewModel roomPostViewModel = this.mViewModel;
        if (roomPostViewModel != null && (C = roomPostViewModel.C()) != null) {
            C.j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.v3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit initViewData$lambda$15;
                    initViewData$lambda$15 = RoomPostBaseFragment.initViewData$lambda$15(RoomPostBaseFragment.this, (BaseDto) obj);
                    return initViewData$lambda$15;
                }
            }));
        }
        PostDetailViewModel postDetailViewModel = this.mDetailViewModel;
        if (postDetailViewModel != null && (A = postDetailViewModel.A()) != null) {
            A.j(this, new d(new Function1() { // from class: com.transsion.postdetail.ui.fragment.w3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit initViewData$lambda$17;
                    initViewData$lambda$17 = RoomPostBaseFragment.initViewData$lambda$17(RoomPostBaseFragment.this, (PostSubjectItem) obj);
                    return initViewData$lambda$17;
                }
            }));
        }
        if (nh.m.f70597a.e() || (iVar = this.mAdapter) == null) {
            return;
        }
        iVar.Y0(getLocalNoNetworkView(false));
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    public abstract boolean isNeedInsertPublishPost();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isShowPageStateLayoutTitle() {
        return false;
    }

    public abstract boolean isStaggeredPost();

    public abstract boolean isSwipeRefreshEnable();

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        showLoadingView();
        loadData$default(this, true, false, 2, null);
        com.transsion.postdetail.util.g.f50219a.d(true);
        initFeedVideo();
    }

    public abstract void loadData(boolean isFirstLoad, boolean isRefresh);

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b(pageName(), false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        HashMap g11;
        super.onCreate(savedInstanceState);
        this.mViewModel = (RoomPostViewModel) new androidx.view.v0(this).a(RoomPostViewModel.class);
        this.mDetailViewModel = (PostDetailViewModel) new androidx.view.v0(this).a(PostDetailViewModel.class);
        this.mPageFrom = hj.i.f64628a.i();
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig == null || (g11 = logViewConfig.g()) == null) {
            return;
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getMHandler().removeCallbacksAndMessages(null);
        dp.a aVar = this.mFeedVideoManager;
        if (aVar != null) {
            aVar.onPageDestroy();
        }
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
                localLogPause();
                dp.a aVar = this.mFeedVideoManager;
                if (aVar != null) {
                    aVar.b();
                }
            } else {
                logResume();
                dp.a aVar2 = this.mFeedVideoManager;
                if (aVar2 != null) {
                    aVar2.c();
                }
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    public abstract void onItemHeaderClick(PostSubjectItem item);

    public abstract String onItemHeaderModuleName();

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        localLogPause();
        dp.a aVar = this.mFeedVideoManager;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.h(permissions, "permissions");
        Intrinsics.h(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == FileHelper.f47736a.l()) {
            if (grantResults.length > 1 && grantResults[0] == 0 && grantResults[1] == 0) {
                PostSaveHelper.f50199a.e(this.postItem);
                return;
            }
            FragmentActivity activity = getActivity();
            Intrinsics.f(activity, "null cannot be cast to non-null type android.app.Activity");
            if (ActivityCompat.j(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return;
            }
            showSettingDialog();
        }
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        dp.a aVar;
        super.onResume();
        if (isVisible() && (aVar = this.mFeedVideoManager) != null) {
            aVar.c();
        }
        String e11 = NegativeFeedbackHelper.f48903a.e();
        if (e11 != null) {
            removePost(e11);
            checkToShowEmptyView();
        }
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
        com.transsion.ninegridview.helper.b bVar = com.transsion.ninegridview.helper.b.f47745a;
        FragmentActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type android.app.Activity");
        bVar.a(activity, 101);
    }

    public void openRoomDetail(PostSubjectItem item) {
        Group group;
        String groupId;
        if (item == null || (group = item.getGroup()) == null || (groupId = group.getGroupId()) == null) {
            return;
        }
        Navigator.x(TheRouter.c("/room/detail").K("id", groupId), requireContext(), null, 2, null);
    }

    public void openSubjectDetail(PostSubjectItem item) {
        Subject subject;
        if (item == null || (subject = item.getSubject()) == null) {
            return;
        }
        Navigator c11 = TheRouter.c("/movie/detail");
        Integer subjectType = subject.getSubjectType();
        Navigator.x(c11.F("subject_type", subjectType != null ? subjectType.intValue() : SubjectType.MOVIE.getValue()).K("id", subject.getSubjectId()).K("ops", subject.getOps()), requireContext(), null, 2, null);
    }

    public void openUserCenter(PostSubjectItem item) {
        User user;
        if (item == null || (user = item.getUser()) == null) {
            return;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setAvatar(user.getAvatar());
        userInfo.setUsername(user.getUsername());
        userInfo.setNickname(user.getNickname());
        Navigator.x(TheRouter.c("/profile/user_profile").K("userId", userInfo.getUserId()), requireContext(), null, 2, null);
    }

    public abstract String pageName();

    public abstract PostAdapterFrom postAdapterFrom();

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        com.transsion.postdetail.ui.adapter.i iVar = this.mAdapter;
        List<Object> data = iVar != null ? iVar.getData() : null;
        boolean z10 = data == null || data.isEmpty();
        if (z10) {
            showLoadingView();
        }
        loadData$default(this, false, z10, 1, null);
    }

    protected final void setMAdapter(com.transsion.postdetail.ui.adapter.i iVar) {
        this.mAdapter = iVar;
    }

    protected final void setMDetailViewModel(PostDetailViewModel postDetailViewModel) {
        this.mDetailViewModel = postDetailViewModel;
    }

    protected final void setMExposureHelper(sj.b bVar) {
        this.mExposureHelper = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMGroupId(String str) {
        this.mGroupId = str;
    }

    protected final void setMPage(String str) {
        this.mPage = str;
    }

    protected final void setMPageFrom(String str) {
        this.mPageFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMParentTypeName(String str) {
        this.mParentTypeName = str;
    }

    protected final void setMPerPage(int i11) {
        this.mPerPage = i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMTopTab(RoomTabItem roomTabItem) {
        this.mTopTab = roomTabItem;
    }

    protected final void setMViewModel(RoomPostViewModel roomPostViewModel) {
        this.mViewModel = roomPostViewModel;
    }

    public final void setOnNumNotExposureListener(ak.q listener) {
        Intrinsics.h(listener, "listener");
        sj.b bVar = this.mExposureHelper;
        if (bVar != null) {
            bVar.p(listener);
        }
    }

    public abstract String subpageName();

    public abstract int tabIndex();

    /* JADX WARN: Multi-variable type inference failed */
    public void updateData(PostSubjectBean bean) {
        List<PostSubjectItem> items;
        PostSubjectItem postSubjectItem;
        String ops;
        HashMap g11;
        HashMap g12;
        List<Object> arrayList;
        r6.f h02;
        r6.f h03;
        r6.f h04;
        r6.f h05;
        List<PostSubjectItem> items2;
        r6.f h06;
        com.transsion.postdetail.ui.adapter.i iVar;
        r6.f h07;
        r6.f h08;
        com.transsion.postdetail.ui.adapter.i iVar2;
        r6.f h09;
        FrameLayout root;
        SwipeRefreshLayout swipeRefreshLayout;
        so.s sVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        HashMap g13;
        hj.b logViewConfig = getLogViewConfig();
        if ((logViewConfig == null || (g13 = logViewConfig.g()) == null || !g13.containsKey("ops")) && bean != null && (items = bean.getItems()) != null && (postSubjectItem = (PostSubjectItem) CollectionsKt.k0(items)) != null && (ops = postSubjectItem.getOps()) != null) {
            hj.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (g12 = logViewConfig2.g()) != null) {
            }
            if (getParentFragment() instanceof PageStatusFragment) {
                Fragment parentFragment = getParentFragment();
                Intrinsics.f(parentFragment, "null cannot be cast to non-null type com.transsion.baseui.fragment.PageStatusFragment<*>");
                hj.b logViewConfig3 = ((PageStatusFragment) parentFragment).getLogViewConfig();
                if (logViewConfig3 != null && (g11 = logViewConfig3.g()) != null) {
                }
            }
        }
        Function0<Unit> function0 = this.mRefreshResultCallback;
        if (function0 != null) {
            function0.invoke();
        }
        showContentView();
        so.s sVar2 = (so.s) getMViewBinding();
        if (sVar2 != null && (swipeRefreshLayout = sVar2.f75828c) != null && swipeRefreshLayout.isRefreshing() && (sVar = (so.s) getMViewBinding()) != null && (swipeRefreshLayout2 = sVar.f75828c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        com.transsion.postdetail.ui.adapter.i iVar3 = this.mAdapter;
        if (iVar3 == null || (arrayList = iVar3.getData()) == null) {
            arrayList = new ArrayList<>();
        }
        if (bean == null || (items2 = bean.getItems()) == null || items2.isEmpty()) {
            if (arrayList.isEmpty()) {
                checkToShowEmptyView();
                return;
            }
            com.transsion.postdetail.ui.adapter.i iVar4 = this.mAdapter;
            if ((iVar4 == null || (h05 = iVar4.h0()) == null || !h05.r()) ? false : true) {
                PostSubjectItem postSubjectItem2 = (PostSubjectItem) CollectionsKt.v0(arrayList);
                if (postSubjectItem2 != null && postSubjectItem2.isRoomCache()) {
                    com.transsion.postdetail.ui.adapter.i iVar5 = this.mAdapter;
                    if (iVar5 == null || (h04 = iVar5.h0()) == null) {
                        return;
                    }
                    h04.s();
                    return;
                }
                if ((bean != null ? bean.getPager() : null) != null) {
                    Pager pager = bean.getPager();
                    if (!(pager != null ? Intrinsics.c(pager.getHasMore(), Boolean.TRUE) : false)) {
                        com.transsion.postdetail.ui.adapter.i iVar6 = this.mAdapter;
                        if (iVar6 == null || (h03 = iVar6.h0()) == null) {
                            return;
                        }
                        r6.f.u(h03, false, 1, null);
                        return;
                    }
                }
                com.transsion.postdetail.ui.adapter.i iVar7 = this.mAdapter;
                if (iVar7 == null || (h02 = iVar7.h0()) == null) {
                    return;
                }
                h02.v();
                return;
            }
            return;
        }
        InterfaceC1015e parentFragment2 = getParentFragment();
        if (parentFragment2 instanceof aq.d) {
            ((aq.d) parentFragment2).O();
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null) {
            logViewConfig4.k(true);
        }
        Pager pager2 = bean.getPager();
        this.mPage = pager2 != null ? pager2.getNextPage() : null;
        if (bean.getSubject() != null) {
            this.mSubject = bean.getSubject();
        }
        if (bean.getGroup() != null) {
            this.mGroup = bean.getGroup();
        }
        if (bean.getIsRefresh()) {
            com.transsion.postdetail.ui.adapter.i iVar8 = this.mAdapter;
            if (iVar8 != null) {
                iVar8.n1(bean.getItems());
            }
            so.s sVar3 = (so.s) getMViewBinding();
            if (sVar3 != null && (root = sVar3.getRoot()) != null) {
                root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.c4
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomPostBaseFragment.updateData$lambda$39(RoomPostBaseFragment.this);
                    }
                });
            }
        } else {
            List<PostSubjectItem> items3 = bean.getItems();
            if (items3 != null) {
                if (this instanceof RoomPostExploreFragment) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : items3) {
                        PostSubjectItem postSubjectItem3 = (PostSubjectItem) obj;
                        if (postSubjectItem3.getGroup() != null || postSubjectItem3.isRoomCacheListStart() || postSubjectItem3.isRoomCacheListEnd()) {
                            arrayList2.add(obj);
                        }
                    }
                    items3 = arrayList2;
                }
                ArrayList arrayList3 = new ArrayList();
                if (arrayList.isEmpty()) {
                    for (PostSubjectItem postSubjectItem4 : items3) {
                        Subject subject = this.mSubject;
                        if (subject != null) {
                            postSubjectItem4.setSubject(subject);
                        }
                        Group group = this.mGroup;
                        if (group != null) {
                            postSubjectItem4.setGroup(group);
                        }
                    }
                    arrayList3.addAll(items3);
                } else {
                    for (PostSubjectItem postSubjectItem5 : items3) {
                        if (!arrayList.contains(postSubjectItem5)) {
                            Subject subject2 = this.mSubject;
                            if (subject2 != null) {
                                postSubjectItem5.setSubject(subject2);
                            }
                            Group group2 = this.mGroup;
                            if (group2 != null) {
                                postSubjectItem5.setGroup(group2);
                            }
                            arrayList3.add(postSubjectItem5);
                        }
                    }
                }
                if (arrayList3.isEmpty()) {
                    com.transsion.postdetail.ui.adapter.i iVar9 = this.mAdapter;
                    if (iVar9 != null && (h06 = iVar9.h0()) != null) {
                        r6.f.u(h06, false, 1, null);
                    }
                    if (arrayList.isEmpty()) {
                        checkToShowEmptyView();
                    }
                } else {
                    com.transsion.postdetail.ui.adapter.i iVar10 = this.mAdapter;
                    if (iVar10 != null) {
                        iVar10.q(arrayList3);
                    }
                }
            }
        }
        com.transsion.postdetail.ui.adapter.i iVar11 = this.mAdapter;
        if (iVar11 != null && (h08 = iVar11.h0()) != null && h08.r() && (iVar2 = this.mAdapter) != null && (h09 = iVar2.h0()) != null) {
            h09.s();
        }
        if (bean.getPager() != null) {
            Pager pager3 = bean.getPager();
            if ((pager3 != null ? Intrinsics.c(pager3.getHasMore(), Boolean.TRUE) : false) || (iVar = this.mAdapter) == null || (h07 = iVar.h0()) == null) {
                return;
            }
            r6.f.u(h07, false, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateRoomCacheData(int position, PostSubjectBean bean) {
        List<Object> arrayList;
        r6.f h02;
        r6.f h03;
        Pager pager;
        r6.f h04;
        List<PostSubjectItem> items;
        r6.f h05;
        com.transsion.postdetail.ui.adapter.i iVar;
        r6.f h06;
        r6.f h07;
        com.transsion.postdetail.ui.adapter.i iVar2;
        r6.f h08;
        FrameLayout root;
        SwipeRefreshLayout swipeRefreshLayout;
        so.s sVar;
        SwipeRefreshLayout swipeRefreshLayout2;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        Function0<Unit> function0 = this.mRefreshResultCallback;
        if (function0 != null) {
            function0.invoke();
        }
        showContentView();
        so.s sVar2 = (so.s) getMViewBinding();
        if (sVar2 != null && (swipeRefreshLayout = sVar2.f75828c) != null && swipeRefreshLayout.isRefreshing() && (sVar = (so.s) getMViewBinding()) != null && (swipeRefreshLayout2 = sVar.f75828c) != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        com.transsion.postdetail.ui.adapter.i iVar3 = this.mAdapter;
        if (iVar3 == null || (arrayList = iVar3.getData()) == null) {
            arrayList = new ArrayList<>();
        }
        if (bean == null || (items = bean.getItems()) == null || items.isEmpty()) {
            if (arrayList.isEmpty()) {
                checkToShowEmptyView();
                return;
            }
            com.transsion.postdetail.ui.adapter.i iVar4 = this.mAdapter;
            if ((iVar4 == null || (h04 = iVar4.h0()) == null || !h04.r()) ? false : true) {
                if ((bean == null || (pager = bean.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.TRUE)) {
                    com.transsion.postdetail.ui.adapter.i iVar5 = this.mAdapter;
                    if (iVar5 == null || (h02 = iVar5.h0()) == null) {
                        return;
                    }
                    h02.v();
                    return;
                }
                com.transsion.postdetail.ui.adapter.i iVar6 = this.mAdapter;
                if (iVar6 == null || (h03 = iVar6.h0()) == null) {
                    return;
                }
                r6.f.u(h03, false, 1, null);
                return;
            }
            return;
        }
        Pager pager2 = bean.getPager();
        this.mPage = pager2 != null ? pager2.getNextPage() : null;
        if (bean.getSubject() != null) {
            this.mSubject = bean.getSubject();
        }
        if (bean.getGroup() != null) {
            this.mGroup = bean.getGroup();
        }
        if (bean.getIsRefresh()) {
            com.transsion.postdetail.ui.adapter.i iVar7 = this.mAdapter;
            if (iVar7 != null) {
                iVar7.n1(bean.getItems());
            }
            so.s sVar3 = (so.s) getMViewBinding();
            if (sVar3 != null && (root = sVar3.getRoot()) != null) {
                root.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.f4
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomPostBaseFragment.updateRoomCacheData$lambda$47(RoomPostBaseFragment.this);
                    }
                });
            }
        } else {
            List<PostSubjectItem> items2 = bean.getItems();
            if (items2 != null) {
                if (this instanceof RoomPostExploreFragment) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : items2) {
                        PostSubjectItem postSubjectItem = (PostSubjectItem) obj;
                        if (postSubjectItem.getGroup() != null || postSubjectItem.isRoomCacheListStart() || postSubjectItem.isRoomCacheListEnd()) {
                            arrayList2.add(obj);
                        }
                    }
                    items2 = arrayList2;
                }
                if (items2.isEmpty()) {
                    com.transsion.postdetail.ui.adapter.i iVar8 = this.mAdapter;
                    if (iVar8 != null && (h05 = iVar8.h0()) != null) {
                        r6.f.u(h05, false, 1, null);
                    }
                    if (arrayList.isEmpty()) {
                        checkToShowEmptyView();
                    }
                } else {
                    int i11 = position + 1;
                    com.transsion.postdetail.ui.adapter.i iVar9 = this.mAdapter;
                    if (i11 < (iVar9 != null ? iVar9.getItemCount() : 0)) {
                        com.transsion.postdetail.ui.adapter.i iVar10 = this.mAdapter;
                        if (iVar10 != null) {
                            iVar10.o(i11, items2);
                        }
                    } else {
                        com.transsion.postdetail.ui.adapter.i iVar11 = this.mAdapter;
                        if (iVar11 != null) {
                            if (position < 0) {
                                position = 0;
                            }
                            iVar11.o(position, items2);
                        }
                    }
                }
            }
        }
        com.transsion.postdetail.ui.adapter.i iVar12 = this.mAdapter;
        if (iVar12 != null && (h07 = iVar12.h0()) != null && h07.r() && (iVar2 = this.mAdapter) != null && (h08 = iVar2.h0()) != null) {
            h08.s();
        }
        Pager pager3 = bean.getPager();
        if ((pager3 != null ? Intrinsics.c(pager3.getHasMore(), Boolean.TRUE) : false) || (iVar = this.mAdapter) == null || (h06 = iVar.h0()) == null) {
            return;
        }
        r6.f.u(h06, false, 1, null);
    }
}
