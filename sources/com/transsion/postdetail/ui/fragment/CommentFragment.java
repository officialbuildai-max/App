package com.transsion.postdetail.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.DefaultView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.bean.CommentBean;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentBody;
import com.transsion.postdetail.bean.CommentLikeBean;
import com.transsion.postdetail.bean.CommentLikeBody;
import com.transsion.postdetail.bean.CommentListBean;
import com.transsion.postdetail.bean.Pager;
import com.transsion.postdetail.comment.CommentDeleteDialogFragment;
import com.transsion.postdetail.comment.SocialStatus;
import com.transsion.postdetail.comment.g;
import com.transsion.postdetail.comment.i0;
import com.transsion.postdetail.util.m;
import com.transsion.postdetail.viewmodel.CommentViewModel;
import com.transsion.postdetailapi.CommentTopicType;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsion.upload.bean.UploadFileType;
import com.transsion.upload.bean.UploadTstTokenStorageType;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import lg.a;
import nh.n;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ì\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002x{B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0007J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0007J#\u0010\u001c\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0007J\u0019\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b!\u0010\u0013J'\u0010&\u001a\u00020\b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\u0007J#\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00102\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102JO\u00109\u001a\u00020\b2\u0006\u00103\u001a\u00020\u001026\u00108\u001a2\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\b04H\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010=\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ!\u0010E\u001a\u00020\b2\u0006\u0010D\u001a\u00020C2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bE\u0010FJ\u0019\u0010G\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020(H\u0016¢\u0006\u0004\bI\u0010*J\u0017\u0010L\u001a\u00020\b2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ%\u0010O\u001a\u00020\b2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b\u0018\u00010NH\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\bH\u0016¢\u0006\u0004\bQ\u0010\u0007J\u0017\u0010S\u001a\u00020(2\b\u0010R\u001a\u0004\u0018\u00010#¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\bH\u0016¢\u0006\u0004\bU\u0010\u0007J\u000f\u0010V\u001a\u00020\bH\u0016¢\u0006\u0004\bV\u0010\u0007J\u0017\u0010W\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bW\u0010\u0013J#\u0010[\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010Z\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\bH\u0016¢\u0006\u0004\b]\u0010\u0007J1\u0010c\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010^2\u0006\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020_2\u0006\u0010b\u001a\u00020_H\u0016¢\u0006\u0004\bc\u0010dJ\u0019\u0010e\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\be\u0010fJ\u0019\u0010g\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\bg\u0010fJI\u0010i\u001a\u00020\b2:\u00108\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020\b04¢\u0006\u0004\bi\u0010jJ\u0019\u0010k\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\bk\u0010fJ\u0019\u0010l\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\bl\u0010fJ\u001f\u0010o\u001a\u00020\b2\u0006\u0010n\u001a\u00020m2\u0006\u0010b\u001a\u00020_H\u0016¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010#¢\u0006\u0004\bq\u0010fJ\u000f\u0010r\u001a\u00020\bH\u0016¢\u0006\u0004\br\u0010\u0007J\u0017\u0010t\u001a\u00020\b2\u0006\u0010s\u001a\u00020(H\u0016¢\u0006\u0004\bt\u0010uJ\u000f\u0010v\u001a\u00020\bH\u0016¢\u0006\u0004\bv\u0010\u0007R\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001b\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bO\u0010\u008f\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R'\u0010\u009a\u0001\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009c\u0001R\u0019\u0010¢\u0001\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0019\u0010¤\u0001\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¡\u0001R\u0019\u0010§\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010©\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010|R\u0018\u0010«\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bª\u0001\u0010|R\u0017\u0010¬\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010|R\u001a\u0010Z\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0017\u0010¯\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010|R\u0019\u0010±\u0001\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010¡\u0001R\u0019\u0010³\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010¦\u0001R#\u0010¹\u0001\u001a\u0005\u0018\u00010´\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001R*\u0010¾\u0001\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bº\u0001\u0010\u009c\u0001\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0005\b½\u0001\u0010\u0013R,\u0010Æ\u0001\u001a\u0005\u0018\u00010¿\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001d\u0010Í\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100Ë\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bg\u0010Ì\u0001R\u001a\u0010 \u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u009c\u0001R\u001b\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010\u009c\u0001R\u001b\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010\u009c\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010\u009c\u0001R\u001a\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010\u009c\u0001R\u001b\u0010×\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010\u009c\u0001R\u001a\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bk\u0010\u009c\u0001R\u001b\u0010Ú\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010\u009c\u0001R#\u0010Þ\u0001\u001a\f\u0012\u0005\u0012\u00030Ü\u0001\u0018\u00010Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010Ý\u0001R\u0018\u0010ß\u0001\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010|R\u001b\u0010â\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u0019\u0010ä\u0001\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010¦\u0001R3\u0010ç\u0001\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001c\u0010ë\u0001\u001a\u0005\u0018\u00010è\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001¨\u0006í\u0001"}, d2 = {"Lcom/transsion/postdetail/ui/fragment/CommentFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lso/j;", "Lcom/transsion/postdetail/comment/i0;", "Lcom/transsion/postdetail/comment/g0;", "Lep/a;", "<init>", "()V", "", "initAdapter", "initExposureHelper", "I0", "initViewModel", "j1", "loadData", "W0", "", "txt", "S0", "(Ljava/lang/String;)V", "showEmpty", "f1", "Lcom/transsion/postdetail/bean/CommentListBean;", "data", "B0", "(Lcom/transsion/postdetail/bean/CommentListBean;)V", "F0", "postId", "a1", "(Ljava/lang/String;Lcom/transsion/postdetail/bean/CommentListBean;)V", "k1", "R0", "commentId", "i1", "Ljava/util/ArrayList;", "Lcom/transsion/moviedetailapi/bean/CommentBean;", "Lkotlin/collections/ArrayList;", "list", "D0", "(Ljava/util/ArrayList;)V", "", "checkLogin", "()Z", "h1", "moduleName", "X0", "(Ljava/lang/String;Ljava/lang/String;)V", "Lfp/a;", "operationMenu", "C0", "(Lfp/a;)V", "path", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bucket", "callback", "l1", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "G0", "(Landroid/view/LayoutInflater;)Lso/j;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "s", "(Landroid/view/View;)V", CampaignEx.JSON_KEY_AD_Q, "", "commentCount", "updateCommentCount", "(J)V", "Lkotlin/Function1;", "f", "(Lkotlin/jvm/functions/Function1;)V", "lazyLoadData", WebConstants.FIELD_ITEM, "d1", "(Lcom/transsion/moviedetailapi/bean/CommentBean;)Z", "startLoading", "hideLoading", "E0", "Landroid/text/Editable;", MimeTypes.BASE_TYPE_TEXT, "replyItem", "S", "(Landroid/text/Editable;Lcom/transsion/moviedetailapi/bean/CommentBean;)V", "E", "", "", "start", "before", "count", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "Q", "(Lcom/transsion/moviedetailapi/bean/CommentBean;)V", "z", "likeStatu", "Z0", "(Lkotlin/jvm/functions/Function2;)V", "G", "P", "Lqo/a;", "info", "T", "(Lqo/a;I)V", "c1", "onPause", "hidden", "onHiddenChanged", "(Z)V", "onDestroyView", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "mCommentList", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Z", "mNeedUpdate", "Lcom/transsion/postdetail/comment/n;", "c", "Lcom/transsion/postdetail/comment/n;", "mCommentExpandAdapter", "Lcom/transsion/postdetail/comment/m;", "d", "Lcom/transsion/postdetail/comment/m;", "getMCommentEditInputViewHelper", "()Lcom/transsion/postdetail/comment/m;", "setMCommentEditInputViewHelper", "(Lcom/transsion/postdetail/comment/m;)V", "mCommentEditInputViewHelper", "Lcom/transsion/postdetail/util/m;", "e", "Lcom/transsion/postdetail/util/m;", "mSoftKeyBoardListener", "Lcom/transsion/postdetail/comment/g;", "Lcom/transsion/postdetail/comment/g;", "mCommentEditInputDialog", be.g.f16474b, "Lcom/transsion/postdetail/bean/CommentListBean;", "mMsgData", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "h", "Lcom/transsion/postdetail/viewmodel/CommentViewModel;", "mCommentViewModel", "i", "Lkotlin/jvm/functions/Function1;", "loadResultCallback", com.mbridge.msdk.foundation.same.report.j.f35620b, "Ljava/lang/String;", "topicId", CampaignEx.JSON_KEY_AD_K, "topicType", "l", "I", "page", "m", "mPerPage", "n", "J", "mCommentCount", "o", "mShowDownload", TtmlNode.TAG_P, "mFromDetail", "isNeedCloseInput", CampaignEx.JSON_KEY_AD_R, "Lcom/transsion/moviedetailapi/bean/CommentBean;", "replyLoading", "t", "showCommentCount", TmcStartParams.KEY_URL_SHORT, "lastCreatedTime", "Lcom/transsnet/loginapi/ILoginApi;", "v", "Lkotlin/Lazy;", "getLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "loginApi", "w", "getImagePath", "()Ljava/lang/String;", "setImagePath", "imagePath", "Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "x", "Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "getOnCommentCountChangedListener", "()Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;", "b1", "(Lcom/transsion/postdetail/ui/fragment/CommentFragment$b;)V", "onCommentCountChangedListener", "Lsj/b;", "y", "Lsj/b;", "exposureHelper", "", "Ljava/util/Set;", "exposedCommentIds", "A", "B", "pageFrom", "C", "trackId", "D", "previousTrackId", "previousPageVideoId", "F", "ugcVideoId", "pageName", "H", "collectionId", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "Landroidx/activity/result/b;", "loginLaunch", "isNeedShowLoginActivity", "K", "Landroid/text/Editable;", "mText", "L", "mPostClickTime", "M", "Lkotlin/jvm/functions/Function2;", "mCommentCallback", "Lcom/transsion/postdetail/comment/CommentDeleteDialogFragment;", "N", "Lcom/transsion/postdetail/comment/CommentDeleteDialogFragment;", "mCommentDeleteDialog", "O", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class CommentFragment extends BaseFragment<so.j> implements com.transsion.postdetail.comment.i0, com.transsion.postdetail.comment.g0, ep.a {

    /* renamed from: O, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    private String commentId;

    /* renamed from: B, reason: from kotlin metadata */
    private String pageFrom;

    /* renamed from: C, reason: from kotlin metadata */
    private String trackId;

    /* renamed from: D, reason: from kotlin metadata */
    private String previousTrackId;

    /* renamed from: E, reason: from kotlin metadata */
    private String previousPageVideoId;

    /* renamed from: F, reason: from kotlin metadata */
    private String ugcVideoId;

    /* renamed from: G, reason: from kotlin metadata */
    private String pageName;

    /* renamed from: H, reason: from kotlin metadata */
    private String collectionId;

    /* renamed from: I, reason: from kotlin metadata */
    private androidx.activity.result.b loginLaunch;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isNeedShowLoginActivity;

    /* renamed from: K, reason: from kotlin metadata */
    private Editable mText;

    /* renamed from: L, reason: from kotlin metadata */
    private long mPostClickTime;

    /* renamed from: M, reason: from kotlin metadata */
    private Function2 mCommentCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private CommentDeleteDialogFragment mCommentDeleteDialog;

    /* renamed from: a, reason: from kotlin metadata */
    private RecyclerView mCommentList;

    /* renamed from: b */
    private boolean mNeedUpdate;

    /* renamed from: c, reason: from kotlin metadata */
    private com.transsion.postdetail.comment.n mCommentExpandAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private com.transsion.postdetail.comment.m mCommentEditInputViewHelper;

    /* renamed from: e, reason: from kotlin metadata */
    private com.transsion.postdetail.util.m mSoftKeyBoardListener;

    /* renamed from: f, reason: from kotlin metadata */
    private com.transsion.postdetail.comment.g mCommentEditInputDialog;

    /* renamed from: g */
    private CommentListBean mMsgData;

    /* renamed from: h, reason: from kotlin metadata */
    private CommentViewModel mCommentViewModel;

    /* renamed from: i, reason: from kotlin metadata */
    private Function1 loadResultCallback;

    /* renamed from: j */
    private String topicId;

    /* renamed from: n, reason: from kotlin metadata */
    private long mCommentCount;

    /* renamed from: p */
    private boolean mFromDetail;

    /* renamed from: q */
    private boolean isNeedCloseInput;

    /* renamed from: r */
    private CommentBean replyItem;

    /* renamed from: s, reason: from kotlin metadata */
    private boolean replyLoading;

    /* renamed from: t, reason: from kotlin metadata */
    private int showCommentCount;

    /* renamed from: u */
    private long lastCreatedTime;

    /* renamed from: w, reason: from kotlin metadata */
    private String imagePath;

    /* renamed from: x, reason: from kotlin metadata */
    private b onCommentCountChangedListener;

    /* renamed from: y, reason: from kotlin metadata */
    private sj.b exposureHelper;

    /* renamed from: k */
    private String topicType = CommentTopicType.POST.getValue();

    /* renamed from: l, reason: from kotlin metadata */
    private int page = 1;

    /* renamed from: m, reason: from kotlin metadata */
    private int mPerPage = 10;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean mShowDownload = true;

    /* renamed from: v, reason: from kotlin metadata */
    private final Lazy loginApi = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ui.fragment.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi T0;
            T0 = CommentFragment.T0();
            return T0;
        }
    });

    /* renamed from: z, reason: from kotlin metadata */
    private final Set exposedCommentIds = new LinkedHashSet();

    /* renamed from: com.transsion.postdetail.ui.fragment.CommentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CommentFragment b(Companion companion, String str, String str2, long j11, boolean z10, boolean z11, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i11, Object obj) {
            return companion.a(str, str2, j11, (i11 & 8) != 0 ? true : z10, (i11 & 16) != 0 ? false : z11, (i11 & 32) != 0 ? "" : str3, str4, (i11 & 128) != 0 ? null : str5, (i11 & 256) != 0 ? null : str6, (i11 & 512) != 0 ? null : str7, (i11 & 1024) != 0 ? null : str8, (i11 & 2048) != 0 ? null : str9, (i11 & 4096) != 0 ? null : str10);
        }

        public final CommentFragment a(String str, String str2, long j11, boolean z10, boolean z11, String commentId, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            Intrinsics.h(commentId, "commentId");
            CommentFragment commentFragment = new CommentFragment();
            Bundle bundle = new Bundle();
            bundle.putString(GifImagePreviewActivity.POST_ID, str);
            bundle.putString("TOPIC_TYPE", str2);
            bundle.putLong("comment_count", j11);
            bundle.putBoolean("show_download", z10);
            bundle.putBoolean("from_detail", z11);
            bundle.putString(WebConstants.PAGE_FROM, str3);
            if (commentId.length() > 0) {
                bundle.putString("comment_id", commentId);
            }
            bundle.putString("TRACK_ID", str4);
            bundle.putString("PREVIOUS_TRACK_ID", str5);
            bundle.putString("PREVIOUS_PAGE_VIDEO_ID", str6);
            bundle.putString("UGC_VIDEO_ID", str7);
            bundle.putString("PAGE_NAME", str8);
            bundle.putString("COLLECTION_ID", str9);
            commentFragment.setArguments(bundle);
            return commentFragment;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(long j11);
    }

    /* loaded from: classes6.dex */
    public static final class c implements sj.a {

        /* renamed from: b */
        final /* synthetic */ String f49542b;

        c(String str) {
            this.f49542b = str;
        }

        @Override // sj.a
        public void a(int i11, long j11, View view) {
            String commentId;
            CommentFragment commentFragment = CommentFragment.this;
            String str = this.f49542b;
            try {
                Result.Companion companion = Result.INSTANCE;
                com.transsion.postdetail.comment.n nVar = commentFragment.mCommentExpandAdapter;
                if (nVar != null && i11 >= 0 && i11 < nVar.getItemCount()) {
                    Object f02 = nVar.f0(i11);
                    CommentBean commentBean = f02 instanceof CommentBean ? (CommentBean) f02 : null;
                    if (commentBean != null && (commentId = commentBean.getCommentId()) != null && !commentFragment.exposedCommentIds.contains(commentId)) {
                        commentFragment.exposedCommentIds.add(commentId);
                        com.transsion.postdetail.helper.a.f48920a.g(str, i11, j11, commentId, commentFragment.topicId, commentBean.isSubComment() ? "reply" : "main", commentFragment.pageFrom, commentFragment.trackId, commentFragment.previousTrackId, commentFragment.previousPageVideoId, commentFragment.ugcVideoId, commentFragment.collectionId);
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
    public static final class d implements nh.n {
        d() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            com.transsion.postdetail.comment.n nVar = CommentFragment.this.mCommentExpandAdapter;
            if (nVar == null || !nVar.q0()) {
                return;
            }
            CommentFragment.this.loadData();
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements m.a {
        e() {
        }

        @Override // com.transsion.postdetail.util.m.a
        public void a(int i11) {
            com.transsion.postdetail.comment.g gVar = CommentFragment.this.mCommentEditInputDialog;
            if (gVar != null) {
                CommentFragment commentFragment = CommentFragment.this;
                if (gVar.isShowing() && commentFragment.isNeedCloseInput) {
                    gVar.dismiss();
                }
            }
        }

        @Override // com.transsion.postdetail.util.m.a
        public void b(int i11) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements CommentDeleteDialogFragment.b {
        f() {
        }

        @Override // com.transsion.postdetail.comment.CommentDeleteDialogFragment.b
        public void a(String str) {
            CommentFragment.this.E0(str);
            CommentFragment.this.X0("delete_comment", str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements cw.a {

        /* renamed from: a */
        final /* synthetic */ Function2 f49546a;

        g(Function2 function2) {
            this.f49546a = function2;
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
            this.f49546a.invoke(url, bucket);
        }

        @Override // cw.a
        public void c(String str, String str2, String str3, UploadTstTokenStorageType uploadTstTokenStorageType) {
            a.C0856a.g(lg.a.f68962a, "uploadKey: " + str + "; clientMessage:" + str2 + "; serviceMessage: " + str3, false, 2, null);
        }
    }

    private final void B0(CommentListBean data) {
        List<CommentBean> commentList;
        Pager pager;
        Pager pager2;
        Integer perPage;
        k1(this.mMsgData);
        this.mPerPage = (data == null || (pager2 = data.getPager()) == null || (perPage = pager2.getPerPage()) == null) ? 10 : perPage.intValue();
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        boolean z10 = false;
        if (nVar != null) {
            if (nVar.h0().r()) {
                nVar.h0().s();
            }
            if ((data == null || (pager = data.getPager()) == null) ? false : Intrinsics.c(pager.getHasMore(), Boolean.FALSE)) {
                nVar.h0().t(false);
            }
        }
        if (data != null && (commentList = data.getCommentList()) != null) {
            for (CommentBean commentBean : commentList) {
                this.showCommentCount += commentBean.getSubCommentCnt() + 1;
                Long createdAt = commentBean.getCreatedAt();
                this.lastCreatedTime = createdAt != null ? createdAt.longValue() : 0L;
            }
        }
        com.transsion.postdetail.comment.n nVar2 = this.mCommentExpandAdapter;
        if (nVar2 != null && nVar2.getItemCount() == 0) {
            z10 = true;
        }
        if (z10) {
            showEmpty();
        } else {
            F0();
        }
    }

    private final void C0(fp.a operationMenu) {
        com.transsion.postdetail.comment.m h11;
        List h12 = operationMenu.h();
        if (h12 == null || h12.isEmpty()) {
            return;
        }
        this.imagePath = ((PhotoEntity) h12.get(0)).getLocalPath();
        PhotoEntity photoEntity = (PhotoEntity) h12.get(0);
        com.transsion.postdetail.comment.g gVar = this.mCommentEditInputDialog;
        if (gVar == null || (h11 = gVar.h()) == null) {
            return;
        }
        h11.w(photoEntity);
    }

    private final void D0(ArrayList list) {
        int i11;
        int i12;
        List<CommentBean> subComments;
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        List<CommentBean> commentList3;
        List<CommentBean> commentList4;
        List<CommentBean> commentList5;
        List<CommentBean> commentList6;
        CommentListBean commentListBean = this.mMsgData;
        if (commentListBean != null) {
            if ((commentListBean != null && (commentList6 = commentListBean.getCommentList()) != null && commentList6.isEmpty()) || list == null || list.isEmpty()) {
                return;
            }
            int i13 = 0;
            for (Object obj : list) {
                int i14 = i13 + 1;
                if (i13 < 0) {
                    CollectionsKt.u();
                }
                CommentBean commentBean = (CommentBean) obj;
                CommentListBean commentListBean2 = this.mMsgData;
                if (commentListBean2 == null || (commentList5 = commentListBean2.getCommentList()) == null) {
                    i11 = -1;
                    i12 = -1;
                } else {
                    int i15 = 0;
                    i11 = -1;
                    i12 = -1;
                    for (Object obj2 : commentList5) {
                        int i16 = i15 + 1;
                        if (i15 < 0) {
                            CollectionsKt.u();
                        }
                        CommentBean commentBean2 = (CommentBean) obj2;
                        String commentId = commentBean.getCommentId();
                        if (TextUtils.equals(commentBean2.getCommentId(), commentId)) {
                            i11 = i15;
                        } else {
                            List<CommentBean> subComments2 = commentBean2.getSubComments();
                            if (subComments2 != null) {
                                int i17 = 0;
                                for (Object obj3 : subComments2) {
                                    int i18 = i17 + 1;
                                    if (i17 < 0) {
                                        CollectionsKt.u();
                                    }
                                    CommentBean commentBean3 = (CommentBean) obj3;
                                    if (TextUtils.equals(commentId, commentBean3 != null ? commentBean3.getCommentId() : null)) {
                                        i11 = i15;
                                        i12 = i17;
                                    }
                                    i17 = i18;
                                }
                            }
                        }
                        i15 = i16;
                    }
                }
                if (i11 != -1 || i12 != -1) {
                    if (i11 == -1 || i12 != -1) {
                        CommentListBean commentListBean3 = this.mMsgData;
                        Integer valueOf = (commentListBean3 == null || (commentList2 = commentListBean3.getCommentList()) == null) ? null : Integer.valueOf(commentList2.size());
                        Intrinsics.e(valueOf);
                        if (valueOf.intValue() >= i11) {
                            CommentListBean commentListBean4 = this.mMsgData;
                            CommentBean commentBean4 = (commentListBean4 == null || (commentList = commentListBean4.getCommentList()) == null) ? null : commentList.get(i11);
                            CommentBean remove = (commentBean4 == null || (subComments = commentBean4.getSubComments()) == null) ? null : subComments.remove(i12);
                            a.C0856a.f(lg.a.f68962a, "deleteComment list:", "remove childMsg:" + (remove != null ? remove.getContent() : null), false, 4, null);
                        } else {
                            a.C0856a.f(lg.a.f68962a, "deleteComment list:", "remove childMsg: index ", false, 4, null);
                        }
                    } else {
                        CommentListBean commentListBean5 = this.mMsgData;
                        Integer valueOf2 = (commentListBean5 == null || (commentList4 = commentListBean5.getCommentList()) == null) ? null : Integer.valueOf(commentList4.size());
                        Intrinsics.e(valueOf2);
                        if (valueOf2.intValue() >= i11) {
                            CommentListBean commentListBean6 = this.mMsgData;
                            CommentBean remove2 = (commentListBean6 == null || (commentList3 = commentListBean6.getCommentList()) == null) ? null : commentList3.remove(i11);
                            a.C0856a.f(lg.a.f68962a, "deleteComment list:", "remove parentsMsg:" + (remove2 != null ? remove2.getContent() : null), false, 4, null);
                        } else {
                            a.C0856a.f(lg.a.f68962a, "deleteComment list:", "remove parentsMsg: index ", false, 4, null);
                        }
                    }
                }
                i13 = i14;
            }
        }
    }

    private final void F0() {
        LinearLayout linearLayout;
        so.j mViewBinding = getMViewBinding();
        if (mViewBinding == null || (linearLayout = mViewBinding.f75679d) == null) {
            return;
        }
        jg.c.g(linearLayout);
    }

    public static final void H0(CommentFragment commentFragment) {
        commentFragment.R0();
    }

    private final void I0() {
        setNetListener(new d());
    }

    public static final void J0(CommentFragment commentFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() != -1) {
            a.C0856a.f(lg.a.f68962a, "loginStatus", "登录失败或者取消", false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "loginStatus", "登录成功", false, 4, null);
        com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f41533a;
        ILoginApi loginApi = commentFragment.getLoginApi();
        hVar.l(loginApi != null ? loginApi.b() : null);
    }

    public static final Unit K0(CommentFragment commentFragment, qo.b bVar) {
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        commentFragment.hideLoading();
        if (bVar == null) {
            commentFragment.k1(commentFragment.mMsgData);
            return Unit.f67184a;
        }
        CommentListBean commentListBean = commentFragment.mMsgData;
        if (commentListBean == null) {
            commentFragment.k1(commentListBean);
            return Unit.f67184a;
        }
        if (commentListBean != null) {
            CommentListBean b11 = bVar.b();
            commentListBean.setPager(b11 != null ? b11.getPager() : null);
        }
        CommentListBean commentListBean2 = commentFragment.mMsgData;
        if (commentListBean2 != null && (commentList = commentListBean2.getCommentList()) != null) {
            Iterator<T> it = commentList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CommentBean commentBean = (CommentBean) it.next();
                if (Intrinsics.c(commentBean.getCommentId(), bVar.a().a())) {
                    CommentListBean b12 = bVar.b();
                    if (b12 != null && (commentList2 = b12.getCommentList()) != null) {
                        List<CommentBean> subComments = commentBean.getSubComments();
                        List<CommentBean> U0 = subComments != null ? CollectionsKt.U0(subComments) : null;
                        if (U0 != null) {
                            U0.addAll(commentList2);
                        }
                        commentBean.setSubComments(U0);
                    }
                }
            }
        }
        commentFragment.k1(commentFragment.mMsgData);
        return Unit.f67184a;
    }

    public static final Unit L0(CommentFragment commentFragment, CommentBean commentBean) {
        List<CommentBean> commentList;
        List<Object> data;
        List<CommentBean> arrayList;
        com.transsion.postdetail.comment.m h11;
        com.transsion.postdetail.comment.m h12;
        Editable h13;
        final int i11 = 0;
        commentFragment.replyLoading = false;
        com.transsion.postdetail.comment.g gVar = commentFragment.mCommentEditInputDialog;
        if (gVar != null) {
            gVar.f();
        }
        if (commentBean == null) {
            uh.b.f76876a.d(R$string.comment_failed);
            return Unit.f67184a;
        }
        uh.b.f76876a.d(R$string.comment_success);
        com.transsion.postdetail.comment.g gVar2 = commentFragment.mCommentEditInputDialog;
        if (gVar2 != null && (h12 = gVar2.h()) != null && (h13 = h12.h()) != null) {
            h13.clear();
        }
        com.transsion.postdetail.comment.g gVar3 = commentFragment.mCommentEditInputDialog;
        if (gVar3 != null && (h11 = gVar3.h()) != null) {
            h11.u();
        }
        com.transsion.postdetail.comment.g gVar4 = commentFragment.mCommentEditInputDialog;
        if (gVar4 != null) {
            gVar4.dismiss();
        }
        if (commentFragment.replyItem == null) {
            CommentListBean commentListBean = commentFragment.mMsgData;
            if (commentListBean == null) {
                commentFragment.mMsgData = new CommentListBean(CollectionsKt.h(commentBean), new Pager(Boolean.FALSE, "2", "1", 10, 1));
            } else {
                if (commentListBean != null) {
                    if (commentListBean == null || (arrayList = commentListBean.getCommentList()) == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(0, commentBean);
                    commentListBean.setCommentList(arrayList);
                }
                commentFragment.mCommentCount++;
            }
            commentFragment.j1();
            commentFragment.k1(commentFragment.mMsgData);
            RecyclerView recyclerView = commentFragment.mCommentList;
            if (recyclerView != null) {
                recyclerView.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommentFragment.M0(CommentFragment.this);
                    }
                });
            }
        } else {
            commentFragment.mCommentCount++;
            CommentListBean commentListBean2 = commentFragment.mMsgData;
            if (commentListBean2 != null && (commentList = commentListBean2.getCommentList()) != null) {
                Iterator<T> it = commentList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CommentBean commentBean2 = (CommentBean) it.next();
                    if (Intrinsics.c(commentBean2.getCommentId(), commentBean.getRootCommentId())) {
                        List<CommentBean> subComments = commentBean2.getSubComments();
                        if (subComments != null) {
                            subComments.add(commentBean);
                        }
                        commentBean2.setSubCommentCnt(commentBean2.getSubCommentCnt() + 1);
                        commentFragment.j1();
                        commentFragment.k1(commentFragment.mMsgData);
                        com.transsion.postdetail.comment.n nVar = commentFragment.mCommentExpandAdapter;
                        if (nVar != null && (data = nVar.getData()) != null) {
                            Iterator<T> it2 = data.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                Object next = it2.next();
                                int i12 = i11 + 1;
                                if (i11 < 0) {
                                    CollectionsKt.u();
                                }
                                if (Intrinsics.c((n6.a) next, commentBean)) {
                                    RecyclerView recyclerView2 = commentFragment.mCommentList;
                                    if (recyclerView2 != null) {
                                        recyclerView2.post(new Runnable() { // from class: com.transsion.postdetail.ui.fragment.d
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                CommentFragment.N0(CommentFragment.this, i11);
                                            }
                                        });
                                    }
                                } else {
                                    i11 = i12;
                                }
                            }
                        }
                    }
                }
            }
        }
        ty.b a11 = ty.b.f76540a.a();
        String commentId = commentBean.getCommentId();
        if (commentId == null) {
            commentId = "";
        }
        a11.d(1, commentId, String.valueOf(commentFragment.mCommentCount), commentFragment.topicId);
        return Unit.f67184a;
    }

    public static final void M0(CommentFragment commentFragment) {
        RecyclerView.m layoutManager;
        try {
            RecyclerView recyclerView = commentFragment.mCommentList;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(0);
        } catch (Exception unused) {
        }
    }

    public static final void N0(CommentFragment commentFragment, int i11) {
        RecyclerView.m layoutManager;
        try {
            RecyclerView recyclerView = commentFragment.mCommentList;
            if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(i11);
        } catch (Exception unused) {
        }
    }

    public static final Unit O0(CommentLikeBean commentLikeBean) {
        return Unit.f67184a;
    }

    public static final Unit P0(CommentFragment commentFragment, BaseDto baseDto) {
        commentFragment.E0(baseDto != null ? (String) baseDto.getData() : null);
        return Unit.f67184a;
    }

    public static final Unit Q0(CommentFragment commentFragment, CommentListBean commentListBean) {
        com.transsion.postdetail.comment.n nVar;
        r6.f h02;
        commentFragment.hideLoading();
        if (commentListBean != null || (((nVar = commentFragment.mCommentExpandAdapter) != null && (nVar == null || nVar.getItemCount() != 0)) || nh.m.f70597a.e())) {
            commentFragment.a1(commentFragment.topicId, commentListBean);
            commentFragment.B0(commentListBean);
            Function1 function1 = commentFragment.loadResultCallback;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            return Unit.f67184a;
        }
        commentFragment.f1();
        com.transsion.postdetail.comment.n nVar2 = commentFragment.mCommentExpandAdapter;
        if (nVar2 != null && (h02 = nVar2.h0()) != null) {
            h02.s();
        }
        Function1 function12 = commentFragment.loadResultCallback;
        if (function12 != null) {
            function12.invoke(Boolean.FALSE);
        }
        return Unit.f67184a;
    }

    private final void R0() {
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            String str = this.topicId;
            if (str == null) {
                str = "";
            }
            String str2 = this.topicType;
            int i11 = this.page + 1;
            this.page = i11;
            commentViewModel.h(str, str2, "0", String.valueOf(i11), this.mPerPage, "");
        }
    }

    private final void S0(String txt) {
    }

    public static final ILoginApi T0() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    public static final Unit U0(CommentFragment commentFragment, fp.a it) {
        Intrinsics.h(it, "it");
        Integer e11 = it.e();
        if (e11 != null && e11.intValue() == 0) {
            commentFragment.C0(it);
        }
        return Unit.f67184a;
    }

    public static final Unit V0(CommentBody commentBody, CommentFragment commentFragment, String data, String bucket) {
        Intrinsics.h(data, "data");
        Intrinsics.h(bucket, "bucket");
        if (data.length() > 0) {
            List<String> imageList = commentBody.getImageList();
            if (imageList != null) {
                imageList.clear();
            }
            List<String> imageList2 = commentBody.getImageList();
            if (imageList2 != null) {
                imageList2.add(data);
            }
            commentBody.setBucket(bucket);
            CommentViewModel commentViewModel = commentFragment.mCommentViewModel;
            if (commentViewModel != null) {
                commentViewModel.s(commentFragment.topicType, commentBody);
            }
        }
        return Unit.f67184a;
    }

    private final void W0() {
        if (this.mSoftKeyBoardListener == null) {
            this.mSoftKeyBoardListener = new com.transsion.postdetail.util.m();
        }
        com.transsion.postdetail.util.m mVar = this.mSoftKeyBoardListener;
        if (mVar != null) {
            mVar.d(getActivity(), new e());
        }
    }

    public final void X0(String moduleName, String commentId) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        String str = this.topicId;
        if (str == null) {
            str = "";
        }
        hashMap.put("post_id", str);
        if (commentId == null) {
            commentId = "";
        }
        hashMap.put("comment_id", commentId);
        String str2 = this.pageFrom;
        if (str2 != null && str2.length() != 0) {
            String str3 = this.pageFrom;
            Intrinsics.e(str3);
            hashMap.put(WebConstants.PAGE_FROM, str3);
        }
        String str4 = this.trackId;
        if (str4 != null) {
            hashMap.put("track_id", str4);
        }
        String str5 = this.previousTrackId;
        if (str5 != null) {
            hashMap.put("parent_track_id", str5);
        }
        String str6 = this.previousPageVideoId;
        if (str6 != null) {
            hashMap.put("parent_content_id", str6);
        }
        String str7 = this.ugcVideoId;
        if (str7 != null) {
            hashMap.put("content_id", str7);
        }
        String str8 = this.pageName;
        if (str8 == null) {
            str8 = this.mFromDetail ? PostDetailFragment.PAGE_NAME : VideoFragment.PAGE_NAME;
        }
        com.transsion.baselib.helper.a.f43316a.i(str8, hashMap);
    }

    static /* synthetic */ void Y0(CommentFragment commentFragment, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        commentFragment.X0(str, str2);
    }

    private final void a1(String postId, CommentListBean data) {
        List<CommentBean> commentList;
        List<CommentBean> commentList2;
        HashMap<String, CommentBean> G1;
        if (this.mMsgData == null) {
            this.topicId = postId;
            this.mMsgData = data;
            return;
        }
        if (data == null || (commentList = data.getCommentList()) == null) {
            return;
        }
        for (CommentBean commentBean : commentList) {
            com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
            if (nVar != null && (G1 = nVar.G1()) != null) {
                if (G1.containsKey(commentBean != null ? commentBean.getCommentId() : null)) {
                }
            }
            CommentListBean commentListBean = this.mMsgData;
            if (commentListBean != null && (commentList2 = commentListBean.getCommentList()) != null) {
                commentList2.add(commentBean);
            }
        }
    }

    private final boolean checkLogin() {
        ILoginApi loginApi = getLoginApi();
        if (loginApi != null && !loginApi.a()) {
            if (this.loginLaunch == null) {
                this.isNeedShowLoginActivity = true;
            }
            if (isAdded() && !isDetached() && !isRemoving()) {
                androidx.activity.result.b bVar = this.loginLaunch;
                if (bVar == null) {
                    return false;
                }
                Context requireContext = requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                Intent o11 = loginApi.o(requireContext);
                o11.putExtra("title_name", getString(R$string.comment_login_title));
                bVar.a(o11);
                return false;
            }
        }
        return true;
    }

    public static final void e1(CommentFragment commentFragment, DialogInterface dialogInterface) {
        if (dialogInterface instanceof com.transsion.postdetail.comment.g) {
            com.transsion.postdetail.comment.m h11 = ((com.transsion.postdetail.comment.g) dialogInterface).h();
            Editable h12 = h11 != null ? h11.h() : null;
            commentFragment.mText = h12;
            a.C0856a.f(lg.a.f68962a, "CommentFragment", "text=" + ((Object) h12), false, 4, null);
        }
    }

    private final void f1() {
        TextView textView;
        TextView textView2;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        View inflate = LayoutInflater.from(requireContext()).inflate(R$layout.post_detail_no_comment, (ViewGroup) null);
        if (inflate != null && (textView2 = (TextView) inflate.findViewById(R$id.tv_status)) != null) {
            textView2.setText(R$string.base_net_err);
            textView2.setTextSize(12.0f);
            textView2.setVisibility(0);
        }
        if (inflate != null && (textView = (TextView) inflate.findViewById(R$id.tv_retry)) != null) {
            textView.setText(R$string.comment_retry);
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.fragment.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentFragment.g1(CommentFragment.this, view);
                }
            });
        }
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        if (nVar != null) {
            Intrinsics.e(inflate);
            nVar.Y0(inflate);
        }
    }

    public static final void g1(CommentFragment commentFragment, View view) {
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.base_net_err);
        } else {
            commentFragment.loadData();
            Y0(commentFragment, "retry", null, 2, null);
        }
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.loginApi.getValue();
    }

    private final void h1() {
        com.blankj.utilcode.util.f0.b(300L);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void i1(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.CommentFragment.i1(java.lang.String):void");
    }

    private final void initAdapter() {
        Context context;
        if (this.mCommentExpandAdapter != null || (context = getContext()) == null) {
            return;
        }
        com.transsion.postdetail.comment.n nVar = new com.transsion.postdetail.comment.n(this);
        r6.f h02 = nVar.h0();
        h02.z(true);
        h02.y(true);
        h02.D(new p6.f() { // from class: com.transsion.postdetail.ui.fragment.i
            @Override // p6.f
            public final void a() {
                CommentFragment.H0(CommentFragment.this);
            }
        });
        this.mCommentExpandAdapter = nVar;
        RecyclerView recyclerView = this.mCommentList;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        RecyclerView recyclerView2 = this.mCommentList;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mCommentExpandAdapter);
        }
        RecyclerView recyclerView3 = this.mCommentList;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new com.transsion.postdetail.comment.u());
        }
    }

    private final void initExposureHelper() {
        if (this.exposureHelper != null) {
            return;
        }
        String str = this.pageName;
        if (str == null) {
            str = this.mFromDetail ? PostDetailFragment.PAGE_NAME : VideoFragment.PAGE_NAME;
        }
        sj.b bVar = new sj.b(0.6f, new c(str), false, 4, null);
        bVar.n(2);
        this.exposureHelper = bVar;
        RecyclerView recyclerView = this.mCommentList;
        if (recyclerView != null) {
            Intrinsics.e(bVar);
            recyclerView.addOnScrollListener(bVar);
        }
    }

    private final void initViewModel() {
        CommentViewModel commentViewModel = (CommentViewModel) new androidx.view.v0(this).a(CommentViewModel.class);
        commentViewModel.k().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = CommentFragment.Q0(CommentFragment.this, (CommentListBean) obj);
                return Q0;
            }
        }));
        commentViewModel.l().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = CommentFragment.K0(CommentFragment.this, (qo.b) obj);
                return K0;
            }
        }));
        commentViewModel.n().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L0;
                L0 = CommentFragment.L0(CommentFragment.this, (CommentBean) obj);
                return L0;
            }
        }));
        commentViewModel.m().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit O0;
                O0 = CommentFragment.O0((CommentLikeBean) obj);
                return O0;
            }
        }));
        commentViewModel.j().j(getViewLifecycleOwner(), new o(new Function1() { // from class: com.transsion.postdetail.ui.fragment.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P0;
                P0 = CommentFragment.P0(CommentFragment.this, (BaseDto) obj);
                return P0;
            }
        }));
        this.mCommentViewModel = commentViewModel;
    }

    private final void j1() {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        so.j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatTextView2 = mViewBinding.f75680e) != null) {
            appCompatTextView2.setVisibility(this.mFromDetail ? 8 : 0);
        }
        so.j mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatTextView = mViewBinding2.f75680e) != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String string = getString(R$string.comments);
            Intrinsics.g(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{com.transsion.baseui.util.j.a(this.mCommentCount)}, 1));
            Intrinsics.g(format, "format(...)");
            appCompatTextView.setText(format);
        }
        b bVar = this.onCommentCountChangedListener;
        if (bVar != null) {
            bVar.a(this.mCommentCount);
        }
    }

    private final void k1(CommentListBean data) {
        initAdapter();
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        if (nVar != null) {
            nVar.K1(data);
        }
    }

    private final void l1(String path, Function2 callback) {
        cw.c.f61054a.f(path, UploadFileType.OBJECT_NAME_IMAGE, true, new g(callback));
    }

    public final void loadData() {
        com.transsion.postdetail.comment.n nVar;
        if (this.mMsgData == null && (((nVar = this.mCommentExpandAdapter) == null || (nVar != null && nVar.getItemCount() == 0)) && !nh.m.f70597a.e())) {
            f1();
            return;
        }
        startLoading();
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            String str = this.topicId;
            if (str == null) {
                str = "";
            }
            String str2 = this.topicType;
            String valueOf = String.valueOf(this.page);
            int i11 = this.mPerPage;
            String str3 = this.commentId;
            commentViewModel.h(str, str2, "0", valueOf, i11, str3 == null ? "" : str3);
        }
    }

    private final void showEmpty() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        DefaultView defaultView = new DefaultView(requireContext);
        defaultView.setStyle(DefaultView.DefaultViewStyle.STYLE_IMAGE_DES);
        String string = getString(R$string.comment_empty);
        Intrinsics.g(string, "getString(...)");
        defaultView.setDescText(string);
        defaultView.setDefaultImage(R$drawable.icon_comment_empty);
        defaultView.setMinimumHeight(com.blankj.utilcode.util.a0.a(250.0f));
        com.transsion.postdetail.comment.n nVar = this.mCommentExpandAdapter;
        if (nVar != null) {
            nVar.Y0(defaultView);
        }
    }

    @Override // com.transsion.postdetail.comment.i0
    public void E() {
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        SelectImageActivity.Companion companion = SelectImageActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        companion.a(requireContext, 0, 1, null);
    }

    public final void E0(String commentId) {
        try {
            i1(commentId);
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                a.C0856a.f(lg.a.f68962a, "deleteComment", message, false, 4, null);
            }
        }
    }

    @Override // com.transsion.postdetail.comment.g0
    public void G(CommentBean r42) {
        com.transsion.postdetail.comment.m mVar = this.mCommentEditInputViewHelper;
        CommentBean i11 = mVar != null ? mVar.i() : null;
        if (!Intrinsics.c(i11 != null ? i11.getCommentId() : null, r42 != null ? r42.getCommentId() : null)) {
            com.transsion.postdetail.comment.m mVar2 = this.mCommentEditInputViewHelper;
            if (mVar2 != null) {
                mVar2.t();
            }
            com.transsion.postdetail.comment.m mVar3 = this.mCommentEditInputViewHelper;
            if (mVar3 != null) {
                mVar3.v(r42);
            }
        }
        d1(r42);
        Y0(this, "reply", null, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: G0 */
    public so.j getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        so.j c11 = so.j.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.postdetail.comment.g0
    public void P(CommentBean r12) {
        c1(r12);
    }

    @Override // com.transsion.postdetail.comment.g0
    public void Q(CommentBean r52) {
        String uid;
        S0("跳转个人页面");
        if (r52 != null && (uid = r52.getUid()) != null) {
            Navigator.x(TheRouter.c("/profile/user_profile").K("userId", uid), requireContext(), null, 2, null);
        }
        Y0(this, "avatar_comment", null, 2, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v5 java.lang.String, still in use, count: 2, list:
          (r6v5 java.lang.String) from 0x00b6: IF  (r6v5 java.lang.String) == (null java.lang.String)  -> B:39:0x00a5 A[HIDDEN]
          (r6v5 java.lang.String) from 0x00b9: PHI (r6v4 java.lang.String) = (r6v3 java.lang.String), (r6v5 java.lang.String) binds: [B:75:0x00bc, B:73:0x00b6] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    @Override // com.transsion.postdetail.comment.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S(android.text.Editable r25, com.transsion.moviedetailapi.bean.CommentBean r26) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.CommentFragment.S(android.text.Editable, com.transsion.moviedetailapi.bean.CommentBean):void");
    }

    @Override // com.transsion.postdetail.comment.g0
    public void T(qo.a info, int count) {
        Intrinsics.h(info, "info");
        S0("加载更多");
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            commentViewModel.p(info, this.topicType, String.valueOf(info.c()), this.mPerPage);
        }
    }

    public final void Z0(Function2 callback) {
        Intrinsics.h(callback, "callback");
        this.mCommentCallback = callback;
    }

    @Override // com.transsion.postdetail.comment.i0, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        i0.a.a(this, editable);
    }

    public final void b1(b bVar) {
        this.onCommentCountChangedListener = bVar;
    }

    @Override // com.transsion.postdetail.comment.i0, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        i0.a.b(this, charSequence, i11, i12, i13);
    }

    public final void c1(CommentBean r72) {
        FragmentManager childFragmentManager;
        UserInfo i11;
        if (r72 == null) {
            return;
        }
        String content = r72.getContent();
        String str = null;
        this.mCommentDeleteDialog = content != null ? CommentDeleteDialogFragment.INSTANCE.a(r72.getCommentId(), this.topicType, content) : null;
        try {
            if (isAdded() && (childFragmentManager = getChildFragmentManager()) != null) {
                childFragmentManager.g0();
                CommentDeleteDialogFragment commentDeleteDialogFragment = this.mCommentDeleteDialog;
                if ((commentDeleteDialogFragment != null && commentDeleteDialogFragment.isAdded()) || childFragmentManager.k0("commentDelete") != null) {
                    return;
                }
                String uid = r72.getUid();
                ILoginApi loginApi = getLoginApi();
                if (loginApi != null && (i11 = loginApi.i()) != null) {
                    str = i11.getUserId();
                }
                boolean equals = TextUtils.equals(uid, str);
                CommentDeleteDialogFragment commentDeleteDialogFragment2 = this.mCommentDeleteDialog;
                if (commentDeleteDialogFragment2 != null) {
                    commentDeleteDialogFragment2.o0(new f());
                }
                CommentDeleteDialogFragment commentDeleteDialogFragment3 = this.mCommentDeleteDialog;
                if (commentDeleteDialogFragment3 != null) {
                    commentDeleteDialogFragment3.q0(childFragmentManager, "commentDelete", equals);
                }
            }
            h1();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final boolean d1(CommentBean r42) {
        ro.a g11;
        if (!isAdded() || isDetached() || isRemoving()) {
            return false;
        }
        if (this.mCommentEditInputDialog == null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            g.a c11 = new g.a(requireContext).d(300).c(this);
            com.transsion.postdetail.comment.m mVar = this.mCommentEditInputViewHelper;
            com.transsion.postdetail.comment.g a11 = c11.b(mVar != null ? mVar.h() : null).e(r42).a();
            this.mCommentEditInputDialog = a11;
            if (a11 != null) {
                a11.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.transsion.postdetail.ui.fragment.j
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        CommentFragment.e1(CommentFragment.this, dialogInterface);
                    }
                });
            }
        }
        com.transsion.postdetail.comment.g gVar = this.mCommentEditInputDialog;
        if (gVar == null || gVar.isShowing()) {
            return true;
        }
        com.transsion.postdetail.comment.g gVar2 = this.mCommentEditInputDialog;
        if (gVar2 != null) {
            gVar2.j(this.mText);
        }
        com.transsion.postdetail.comment.g gVar3 = this.mCommentEditInputDialog;
        if (gVar3 != null && (g11 = gVar3.g()) != null) {
            g11.i(r42);
        }
        com.transsion.postdetail.comment.g gVar4 = this.mCommentEditInputDialog;
        if (gVar4 == null) {
            return true;
        }
        gVar4.show();
        return true;
    }

    @Override // ep.a
    public void f(Function1 callback) {
        this.loadResultCallback = callback;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        so.j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f75678c) != null) {
            jg.c.k(recyclerView);
        }
        so.j mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (linearLayout = mViewBinding2.f75679d) == null) {
            return;
        }
        jg.c.g(linearLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View r12, Bundle savedInstanceState) {
        Intrinsics.h(r12, "view");
        this.mCommentList = (RecyclerView) r12.findViewById(R$id.comment_list);
        initAdapter();
        W0();
        initExposureHelper();
        S0("onViewCreated");
        initViewModel();
        j1();
        I0();
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.postdetail.ui.fragment.g
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                CommentFragment.J0(CommentFragment.this, (ActivityResult) obj);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        CommentListBean commentListBean = this.mMsgData;
        if (commentListBean == null) {
            loadData();
        } else {
            B0(commentListBean);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.topicId = arguments.getString(GifImagePreviewActivity.POST_ID);
            String string = arguments.getString("TOPIC_TYPE");
            if (string == null) {
                string = CommentTopicType.POST.getValue();
            }
            this.topicType = string;
            this.mCommentCount = arguments.getLong("comment_count");
            this.mShowDownload = arguments.getBoolean("show_download", true);
            this.mFromDetail = arguments.getBoolean("from_detail", false);
            this.commentId = arguments.getString("comment_id", "");
            this.pageFrom = arguments.getString(WebConstants.PAGE_FROM);
            this.trackId = arguments.getString("TRACK_ID");
            this.previousTrackId = arguments.getString("PREVIOUS_TRACK_ID");
            this.previousPageVideoId = arguments.getString("PREVIOUS_PAGE_VIDEO_ID");
            this.ugcVideoId = arguments.getString("UGC_VIDEO_ID");
            this.pageName = arguments.getString("PAGE_NAME");
            this.collectionId = arguments.getString("COLLECTION_ID");
        }
        Function1 function1 = new Function1() { // from class: com.transsion.postdetail.ui.fragment.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U0;
                U0 = CommentFragment.U0(CommentFragment.this, (fp.a) obj);
                return U0;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = fp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        sj.b bVar = this.exposureHelper;
        if (bVar != null && (recyclerView = this.mCommentList) != null) {
            recyclerView.removeOnScrollListener(bVar);
        }
        this.exposureHelper = null;
        this.exposedCommentIds.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        sj.b bVar;
        super.onHiddenChanged(hidden);
        if (!hidden || (bVar = this.exposureHelper) == null) {
            return;
        }
        bVar.f();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sj.b bVar = this.exposureHelper;
        if (bVar != null) {
            bVar.f();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s11, int start, int before, int count) {
        S0("onTextChanged");
    }

    @Override // ep.a
    public boolean q() {
        return d1(null);
    }

    @Override // ep.a
    public void s(View r102) {
        if (r102 == null || this.mCommentEditInputViewHelper != null) {
            return;
        }
        this.mCommentEditInputViewHelper = new com.transsion.postdetail.comment.m(r102, null, new SocialStatus(false, false, false, this.mShowDownload, 7, null), false, 10, null);
        ro.a aVar = new ro.a();
        aVar.h(300);
        aVar.f(this);
        aVar.g(null);
        com.transsion.postdetail.comment.m mVar = this.mCommentEditInputViewHelper;
        if (mVar != null) {
            mVar.k(aVar);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        LinearLayout linearLayout;
        RecyclerView recyclerView;
        so.j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f75678c) != null) {
            jg.c.g(recyclerView);
        }
        so.j mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (linearLayout = mViewBinding2.f75679d) == null) {
            return;
        }
        jg.c.k(linearLayout);
    }

    @Override // ep.a
    public void updateCommentCount(long commentCount) {
        this.mCommentCount = commentCount;
        j1();
    }

    @Override // com.transsion.postdetail.comment.g0
    public void z(CommentBean r52) {
        S0("点赞");
        if (r52 == null || r52.getCommentId() == null) {
            return;
        }
        String commentId = r52.getCommentId();
        Boolean likeStatu = r52.getLikeStatu();
        Boolean bool = Boolean.TRUE;
        CommentLikeBody commentLikeBody = new CommentLikeBody(commentId, Integer.valueOf(!Intrinsics.c(likeStatu, bool) ? 1 : 0));
        CommentViewModel commentViewModel = this.mCommentViewModel;
        if (commentViewModel != null) {
            commentViewModel.q(commentLikeBody);
        }
        X0(Intrinsics.c(r52.getIsHot(), bool) ? Intrinsics.c(r52.getLikeStatu(), bool) ? "like_hot_comment" : "dislike_hot_comment" : Intrinsics.c(r52.getLikeStatu(), bool) ? "like_comment" : "dislike_comment", r52.getCommentId());
        Function2 function2 = this.mCommentCallback;
        if (function2 != null) {
        }
    }
}
