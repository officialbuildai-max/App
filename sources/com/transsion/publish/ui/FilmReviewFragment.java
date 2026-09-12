package com.transsion.publish.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.PublishManager;
import com.transsion.publish.PublishService;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.api.PhotoEntity;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.api.bean.MediaAudioEntity;
import com.transsion.publish.api.bean.MediaCoverEntity;
import com.transsion.publish.api.bean.MediaImageEntity;
import com.transsion.publish.api.bean.MediaLinkEntity;
import com.transsion.publish.api.bean.MediaVideoEntity;
import com.transsion.publish.api.bean.RequestPostEntity;
import com.transsion.publish.api.bean.RequestPostMediaEntity;
import com.transsion.publish.bean.BigImageBean;
import com.transsion.publish.bean.CoverEntity;
import com.transsion.publish.ui.SelectImageActivity;
import com.transsion.publish.view.ObservableScrollView;
import com.transsion.publish.view.operation.OperationBarView;
import com.transsion.publish.view.operation.OperationVerticalBarView;
import com.transsion.room.api.IRoomApi;
import com.transsion.room.api.bean.LocationPlace;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import f.g;
import ip.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import lg.a;
import org.mvel2.ast.ASTNode;

@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Ð\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002Ñ\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0003¢\u0006\u0004\b)\u0010\u0007J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0007J\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b/\u0010.J\u0017\u00100\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b0\u0010.J\u000f\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u0010\u0007J\u000f\u00102\u001a\u00020\bH\u0002¢\u0006\u0004\b2\u0010\u0007J\u0015\u00104\u001a\b\u0012\u0004\u0012\u00020#03H\u0002¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\b\u0012\u0004\u0012\u00020603H\u0002¢\u0006\u0004\b7\u00105J\u001f\u00109\u001a\u00020\b2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000206\u0018\u000103H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b;\u0010.J\u0017\u0010<\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b<\u0010.J\u0017\u0010=\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b=\u0010.J\u0017\u0010>\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b>\u0010.J\u0017\u0010?\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b?\u0010.J\u0017\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010GJ\u0019\u0010J\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\bL\u0010.J\u000f\u0010M\u001a\u00020\bH\u0002¢\u0006\u0004\bM\u0010\u0007J\u0017\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0017H\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\bH\u0002¢\u0006\u0004\bQ\u0010\u0007J\u000f\u0010R\u001a\u00020\bH\u0002¢\u0006\u0004\bR\u0010\u0007J\u000f\u0010S\u001a\u00020\bH\u0002¢\u0006\u0004\bS\u0010\u0007J\u000f\u0010T\u001a\u00020\bH\u0002¢\u0006\u0004\bT\u0010\u0007J\u000f\u0010U\u001a\u00020\bH\u0002¢\u0006\u0004\bU\u0010\u0007J\u0017\u0010X\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\bH\u0002¢\u0006\u0004\bZ\u0010\u0007J\u0017\u0010]\u001a\u00020\b2\u0006\u0010\\\u001a\u00020[H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\bH\u0002¢\u0006\u0004\b_\u0010\u0007J\u000f\u0010`\u001a\u00020\bH\u0002¢\u0006\u0004\b`\u0010\u0007J\u000f\u0010a\u001a\u00020[H\u0002¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\bH\u0002¢\u0006\u0004\bc\u0010\u0007J\u000f\u0010e\u001a\u00020dH\u0016¢\u0006\u0004\be\u0010fJ\u0017\u0010i\u001a\u00020\u00022\u0006\u0010h\u001a\u00020gH\u0016¢\u0006\u0004\bi\u0010jJ!\u0010o\u001a\u00020\b2\u0006\u0010l\u001a\u00020k2\b\u0010n\u001a\u0004\u0018\u00010mH\u0016¢\u0006\u0004\bo\u0010pJ!\u0010q\u001a\u00020\b2\u0006\u0010l\u001a\u00020k2\b\u0010n\u001a\u0004\u0018\u00010mH\u0016¢\u0006\u0004\bq\u0010pJ\r\u0010r\u001a\u00020\b¢\u0006\u0004\br\u0010\u0007J\r\u0010s\u001a\u00020\b¢\u0006\u0004\bs\u0010\u0007J\u000f\u0010t\u001a\u00020\bH\u0016¢\u0006\u0004\bt\u0010\u0007J\u000f\u0010u\u001a\u00020\bH\u0016¢\u0006\u0004\bu\u0010\u0007J\u0017\u0010x\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0016¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0016¢\u0006\u0004\bz\u0010yJ\u0017\u0010{\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b{\u0010YJ\u0017\u0010|\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b|\u0010YJ\u0017\u0010}\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b}\u0010YJ\u0017\u0010~\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b~\u0010YJ\u0017\u0010\u007f\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\b\u007f\u0010YJ\u0019\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0005\b\u0080\u0001\u0010YJ\u0019\u0010\u0081\u0001\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0005\b\u0081\u0001\u0010YJ\u0019\u0010\u0082\u0001\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0005\b\u0082\u0001\u0010YJ\u0011\u0010\u0083\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0083\u0001\u0010\u0007J\u0011\u0010\u0084\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0084\u0001\u0010\u0007J\u0011\u0010\u0085\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0085\u0001\u0010\u0007J\u0011\u0010\u0086\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0086\u0001\u0010\u0007J\u000f\u0010\u0087\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0087\u0001\u0010(R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010\u0091\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0019\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bE\u0010\u0099\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001b\u0010\u009e\u0001\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009d\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0019\u0010¢\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0019\u0010¤\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010£\u0001R\u0019\u0010¥\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010£\u0001R\u0017\u0010¦\u0001\u001a\u00020\u00178\u0002X\u0082D¢\u0006\b\n\u0006\b¦\u0001\u0010£\u0001R\u0017\u0010§\u0001\u001a\u00020\u00178\u0002X\u0082D¢\u0006\b\n\u0006\b§\u0001\u0010£\u0001R\u0019\u0010¨\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010£\u0001R\u0019\u0010«\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010©\u0001R\u0019\u0010¬\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010®\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010©\u0001R\u0019\u0010¯\u0001\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R#\u0010¶\u0001\u001a\u0005\u0018\u00010±\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R#\u0010»\u0001\u001a\u0005\u0018\u00010·\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¸\u0001\u0010³\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R!\u0010À\u0001\u001a\u00030¼\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b½\u0001\u0010³\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001R#\u0010Ã\u0001\u001a\f\u0012\u0005\u0012\u00030Â\u0001\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010Å\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010©\u0001R\u001c\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010È\u0001R\u0019\u0010Ê\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010©\u0001R#\u0010Ì\u0001\u001a\f\u0012\u0005\u0012\u00030Ë\u0001\u0018\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ä\u0001R\u0018\u0010Î\u0001\u001a\u00030Í\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001¨\u0006Ò\u0001"}, d2 = {"Lcom/transsion/publish/ui/FilmReviewFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lhp/h;", "Lcom/tn/lib/widget/dialog/TRDialogListener;", "Lcom/transsion/publish/adapter/a;", "Lip/b$b;", "<init>", "()V", "", "getVideoIconView", "getImageIconView", "showActivityTips", "", "timestamp1", "timestamp2", "", "isMoreThanADay", "(JJ)Z", "requestCurrentLocation", "userPost", "userGrade", "Lcom/transsion/publish/api/bean/RequestPostEntity;", "request", "", EventConstants.KEY_SOURCE, "postService", "(Lcom/transsion/publish/api/bean/RequestPostEntity;I)V", "buildRequest", "()Lcom/transsion/publish/api/bean/RequestPostEntity;", "detectionSelect", "(Lcom/transsion/publish/api/bean/RequestPostEntity;)V", "Lcom/transsion/publish/api/bean/RequestPostMediaEntity;", "mediaTypes", "checkCover", "(Lcom/transsion/publish/api/bean/RequestPostMediaEntity;)V", "Lcom/transsion/publish/api/VsMediaInfo;", "vsMediaInfo", "checkVideoCover", "(Lcom/transsion/publish/api/bean/RequestPostMediaEntity;Lcom/transsion/publish/api/VsMediaInfo;)V", "checkLogin", "()Z", "initViewModel", "observe", "Lfp/a;", "it", "disposeOperate", "(Lfp/a;)V", "refreshLocation", "refreshImage", "initImageAdapter", "initVideoAdapter", "", "getAddVideoEntity", "()Ljava/util/List;", "Lcom/transsion/publish/api/PhotoEntity;", "getAddImageEntity", "photoEntity", "selectPhotosDispose", "(Ljava/util/List;)V", "refreshAudio", "refreshVideo", "refreshCover", "refreshLink", "refreshWork", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "setSubject", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "Lcom/transsion/publish/api/GroupBean;", "groupBean", "setGroup", "(Lcom/transsion/publish/api/GroupBean;)V", "Lcom/transsion/room/api/bean/LocationPlace;", RequestParameters.SUBRESOURCE_LOCATION, "setLocation", "(Lcom/transsion/room/api/bean/LocationPlace;)V", "refreshGroup", "initManagerAdapter", MimeTypes.BASE_TYPE_TEXT, "setStarTips", "(I)V", "deleteAudio", "deleteLocation", "coverClearDialog", "backSaveDialog", "initRegisterMediaSelector", "Landroid/content/Context;", "context", "showLinkEditInputDialog", "(Landroid/content/Context;)V", "checkBottomMargin", "", AppMeasurementSdk.ConditionalUserProperty.VALUE, "clickTrace", "(Ljava/lang/String;)V", "clickPostTrace", "openRoomList", "getPageName", "()Ljava/lang/String;", "hideOpertaionDialog", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)Lhp/h;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initView", "closeAffirm", "checkPost", "lazyLoadData", "onDestroy", "Lcom/tn/lib/widget/dialog/TRDialog;", "dialog", "onLeftButtonClick", "(Lcom/tn/lib/widget/dialog/TRDialog;)V", "onRightButtonClick", "startPhoto", "startVideo", "startAudio", "startWork", "startLink", "startLocation", "startGroup", "put", "onPause", "completeLoad", "onStop", "onResume", "isPostEnable", "Lcom/transsion/publish/adapter/g;", "imageAdapter", "Lcom/transsion/publish/adapter/g;", "Lcom/transsion/publish/adapter/r;", "managerAdapter", "Lcom/transsion/publish/adapter/r;", "Lcom/transsion/publish/adapter/v;", "videoAdapter", "Lcom/transsion/publish/adapter/v;", "operationMenu", "Lfp/a;", "Lcom/transsion/publish/viewmodel/d;", "postViewModel", "Lcom/transsion/publish/viewmodel/d;", "Lcom/transsion/publish/bean/CoverEntity;", "coverPath", "Lcom/transsion/publish/bean/CoverEntity;", "Lcom/transsion/publish/api/GroupBean;", "mSubject", "Lcom/transsion/moviedetailapi/bean/Subject;", "locationBean", "Lcom/transsion/room/api/bean/LocationPlace;", "curLocationBean", "Lcom/transsion/publish/api/bean/MediaLinkEntity;", "linkEntity", "Lcom/transsion/publish/api/bean/MediaLinkEntity;", "publishType", "I", "sourceType", "sourceMode", "TITLE_MAX", "DESC_MAX", "requestGroup", "Z", "postStar", "isBold", "showTime", "J", "hasFocus", "TAG", "Ljava/lang/String;", "Lcom/transsion/room/api/IRoomApi;", "mRoomApi$delegate", "Lkotlin/Lazy;", "getMRoomApi", "()Lcom/transsion/room/api/IRoomApi;", "mRoomApi", "Lcom/transsnet/loginapi/ILoginApi;", "loginApi$delegate", "getLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "loginApi", "Lkp/b;", "publishModel$delegate", "getPublishModel", "()Lkp/b;", "publishModel", "Landroidx/activity/result/b;", "Landroid/content/Intent;", "loginLaunch", "Landroidx/activity/result/b;", "isNeedShowLoginActivity", "Landroid/widget/ImageView;", "videoIcon", "Landroid/widget/ImageView;", "imageIcon", "underOS33", "Landroidx/activity/result/e;", "videoSelectLauncher", "Ljava/lang/Runnable;", "mRunnable", "Ljava/lang/Runnable;", "Companion", "a", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class FilmReviewFragment extends BaseFragment<hp.h> implements TRDialogListener, com.transsion.publish.adapter.a, b.InterfaceC0821b {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String PAGE_NAME = "publish_post";
    private CoverEntity coverPath;
    private LocationPlace curLocationBean;
    private GroupBean groupBean;
    private boolean hasFocus;
    private com.transsion.publish.adapter.g imageAdapter;
    private ImageView imageIcon;
    private boolean isBold;
    private boolean isNeedShowLoginActivity;
    private MediaLinkEntity linkEntity;
    private LocationPlace locationBean;
    private androidx.activity.result.b loginLaunch;
    private final Runnable mRunnable;
    private Subject mSubject;
    private com.transsion.publish.adapter.r managerAdapter;
    private fp.a operationMenu;
    private int postStar;
    private com.transsion.publish.viewmodel.d postViewModel;
    private int publishType;
    private boolean requestGroup;
    private long showTime;
    private int sourceMode;
    private int sourceType;
    private boolean underOS33;
    private com.transsion.publish.adapter.v videoAdapter;
    private ImageView videoIcon;
    private androidx.activity.result.b videoSelectLauncher;
    private final int TITLE_MAX = 100;
    private final int DESC_MAX = 1000;
    private String TAG = PublishManager.TAG;

    /* renamed from: mRoomApi$delegate, reason: from kotlin metadata */
    private final Lazy mRoomApi = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IRoomApi mRoomApi_delegate$lambda$0;
            mRoomApi_delegate$lambda$0 = FilmReviewFragment.mRoomApi_delegate$lambda$0();
            return mRoomApi_delegate$lambda$0;
        }
    });

    /* renamed from: loginApi$delegate, reason: from kotlin metadata */
    private final Lazy loginApi = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ILoginApi loginApi_delegate$lambda$1;
            loginApi_delegate$lambda$1 = FilmReviewFragment.loginApi_delegate$lambda$1();
            return loginApi_delegate$lambda$1;
        }
    });

    /* renamed from: publishModel$delegate, reason: from kotlin metadata */
    private final Lazy publishModel = LazyKt.b(new Function0() { // from class: com.transsion.publish.ui.w
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            kp.b publishModel_delegate$lambda$2;
            publishModel_delegate$lambda$2 = FilmReviewFragment.publishModel_delegate$lambda$2();
            return publishModel_delegate$lambda$2;
        }
    });

    /* renamed from: com.transsion.publish.ui.FilmReviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FilmReviewFragment a(int i11, Subject subject, int i12, GroupBean groupBean) {
            FilmReviewFragment filmReviewFragment = new FilmReviewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sourceType", i11);
            bundle.putInt("sourceMode", i12);
            if (subject != null) {
                bundle.putSerializable("subject", subject);
            }
            if (groupBean != null) {
                bundle.putSerializable("group", groupBean);
            }
            filmReviewFragment.setArguments(bundle);
            return filmReviewFragment;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f50530b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f50531c;

        b(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.f50530b = objectRef;
            this.f50531c = objectRef2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditText editText;
            EditText editText2;
            TextView textView;
            EditText editText3;
            EditText editText4;
            TextView textView2;
            TextView textView3;
            EditText editText5;
            EditText editText6;
            int length = editable != null ? editable.length() : 0;
            if (length <= 0) {
                FilmReviewFragment.this.isBold = false;
                hp.h mViewBinding = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding != null && (editText2 = mViewBinding.f64904d) != null) {
                    editText2.setTypeface((Typeface) this.f50531c.element, 0);
                }
                hp.h mViewBinding2 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding2 != null && (editText = mViewBinding2.f64904d) != null) {
                    editText.invalidate();
                }
            } else if (!FilmReviewFragment.this.isBold) {
                hp.h mViewBinding3 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding3 != null && (editText6 = mViewBinding3.f64904d) != null) {
                    editText6.setTypeface((Typeface) this.f50530b.element, 1);
                }
                hp.h mViewBinding4 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding4 != null && (editText5 = mViewBinding4.f64904d) != null) {
                    editText5.invalidate();
                }
                FilmReviewFragment.this.isBold = true;
            }
            if (length < FilmReviewFragment.this.TITLE_MAX - 20 || length > FilmReviewFragment.this.TITLE_MAX) {
                hp.h mViewBinding5 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding5 != null && (textView = mViewBinding5.f64923w) != null) {
                    textView.setVisibility(8);
                }
            } else {
                hp.h mViewBinding6 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding6 != null && (textView3 = mViewBinding6.f64923w) != null) {
                    textView3.setVisibility(0);
                }
                hp.h mViewBinding7 = FilmReviewFragment.this.getMViewBinding();
                if (mViewBinding7 != null && (textView2 = mViewBinding7.f64923w) != null) {
                    textView2.setText(String.valueOf(FilmReviewFragment.this.TITLE_MAX - length));
                }
            }
            if (length > FilmReviewFragment.this.TITLE_MAX) {
                com.tn.lib.widget.toast.core.h.f41533a.k(R$string.post_title_length_max);
                if (TextUtils.isEmpty(editable)) {
                    return;
                }
                Integer valueOf = editable != null ? Integer.valueOf(editable.length()) : null;
                Intrinsics.e(valueOf);
                if (valueOf.intValue() > FilmReviewFragment.this.TITLE_MAX) {
                    String obj = editable.subSequence(0, FilmReviewFragment.this.TITLE_MAX).toString();
                    hp.h mViewBinding8 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding8 != null && (editText4 = mViewBinding8.f64904d) != null) {
                        editText4.setText(obj);
                    }
                    hp.h mViewBinding9 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding9 == null || (editText3 = mViewBinding9.f64904d) == null) {
                        return;
                    }
                    editText3.setSelection(obj.length());
                }
            }
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
            OperationBarView operationBarView;
            OperationBarView operationBarView2;
            OperationBarView operationBarView3;
            hp.h mViewBinding;
            EditText editText;
            EditText editText2;
            OperationBarView operationBarView4;
            EditText editText3;
            Integer valueOf = editable != null ? Integer.valueOf(editable.length()) : null;
            hp.h mViewBinding2 = FilmReviewFragment.this.getMViewBinding();
            if (mViewBinding2 != null && (editText3 = mViewBinding2.f64903c) != null) {
                Linkify.addLinks(editText3, 1);
            }
            if (valueOf != null) {
                FragmentActivity activity = FilmReviewFragment.this.getActivity();
                Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
                ((FilmReviewActivity) activity).m0(FilmReviewFragment.this.isPostEnable());
                if (valueOf.intValue() >= 995) {
                    hp.h mViewBinding3 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding3 != null && (operationBarView4 = mViewBinding3.f64913m) != null) {
                        operationBarView4.setInputLimitColor(R$color.error_50);
                    }
                } else {
                    hp.h mViewBinding4 = FilmReviewFragment.this.getMViewBinding();
                    if (mViewBinding4 != null && (operationBarView2 = mViewBinding4.f64913m) != null) {
                        operationBarView2.setInputLimitColor(R$color.white_80);
                    }
                }
                if (valueOf.intValue() >= FilmReviewFragment.this.DESC_MAX) {
                    if (TextUtils.isEmpty(editable)) {
                        return;
                    }
                    Integer valueOf2 = editable != null ? Integer.valueOf(editable.length()) : null;
                    Intrinsics.e(valueOf2);
                    if (valueOf2.intValue() > FilmReviewFragment.this.DESC_MAX) {
                        String obj = editable != null ? editable.subSequence(0, FilmReviewFragment.this.DESC_MAX).toString() : null;
                        hp.h mViewBinding5 = FilmReviewFragment.this.getMViewBinding();
                        if (mViewBinding5 != null && (editText2 = mViewBinding5.f64903c) != null) {
                            editText2.setText(obj);
                        }
                        if (obj != null && (mViewBinding = FilmReviewFragment.this.getMViewBinding()) != null && (editText = mViewBinding.f64903c) != null) {
                            editText.setSelection(obj.length());
                        }
                        hp.h mViewBinding6 = FilmReviewFragment.this.getMViewBinding();
                        if (mViewBinding6 == null || (operationBarView3 = mViewBinding6.f64913m) == null) {
                            return;
                        }
                        operationBarView3.updateInputNum(obj != null ? obj.length() : 0);
                        return;
                    }
                    return;
                }
            }
            hp.h mViewBinding7 = FilmReviewFragment.this.getMViewBinding();
            if (mViewBinding7 == null || (operationBarView = mViewBinding7.f64913m) == null) {
                return;
            }
            operationBarView.updateInputNum(valueOf != null ? valueOf.intValue() : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends CountDownTimer {
        d() {
            super(5000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            BubbleTextView bubbleTextView;
            hp.h mViewBinding = FilmReviewFragment.this.getMViewBinding();
            if (mViewBinding == null || (bubbleTextView = mViewBinding.f64902b) == null) {
                return;
            }
            bubbleTextView.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
        }
    }

    public FilmReviewFragment() {
        this.underOS33 = Build.VERSION.SDK_INT < 33;
        this.mRunnable = new Runnable() { // from class: com.transsion.publish.ui.x
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.mRunnable$lambda$36(FilmReviewFragment.this);
            }
        };
    }

    private final void backSaveDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.cover_save_des);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a g11 = aVar.g(string);
            String string2 = getString(R$string.cover_save_right);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a e11 = g11.e(string2);
            String string3 = getString(R$string.cover_save_left);
            Intrinsics.g(string3, "getString(...)");
            e11.j(string3).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(R$color.error_50)).f(this).a().d0(this, "back_save");
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "back_save_dialog");
            hj.i.f64628a.D(getPageName(), hashMap);
        } catch (Exception unused) {
        }
    }

    private final RequestPostEntity buildRequest() {
        String str;
        String str2;
        Double lat;
        Double lon;
        EditText editText;
        String subjectId;
        EditText editText2;
        hp.h mViewBinding = getMViewBinding();
        Editable editable = null;
        String Q = StringsKt.Q(StringsKt.Q(String.valueOf((mViewBinding == null || (editText2 = mViewBinding.f64903c) == null) ? null : editText2.getText()), "\\n", "", false, 4, null), "\\t", "", false, 4, null);
        RequestPostEntity requestPostEntity = new RequestPostEntity();
        GroupBean groupBean = this.groupBean;
        String str3 = "0";
        if (groupBean == null || (str = groupBean.getGroupId()) == null) {
            str = "0";
        }
        requestPostEntity.setGroupId(str);
        requestPostEntity.setScore(String.valueOf(this.postStar));
        requestPostEntity.setLink(this.linkEntity);
        Subject subject = this.mSubject;
        if (subject != null && (subjectId = subject.getSubjectId()) != null) {
            str3 = subjectId;
        }
        requestPostEntity.setSubjectId(str3);
        hp.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (editText = mViewBinding2.f64904d) != null) {
            editable = editText.getText();
        }
        requestPostEntity.setTitle(String.valueOf(editable));
        requestPostEntity.setContent(Q);
        requestPostEntity.setPublishType(this.sourceType);
        LocationPlace locationPlace = this.locationBean;
        double d11 = 0.0d;
        requestPostEntity.setLon((locationPlace == null || (lon = locationPlace.getLon()) == null) ? 0.0d : lon.doubleValue());
        LocationPlace locationPlace2 = this.locationBean;
        if (locationPlace2 != null && (lat = locationPlace2.getLat()) != null) {
            d11 = lat.doubleValue();
        }
        requestPostEntity.setLat(d11);
        LocationPlace locationPlace3 = this.locationBean;
        if (locationPlace3 == null || (str2 = locationPlace3.getName()) == null) {
            str2 = "";
        }
        requestPostEntity.setPoiName(str2);
        detectionSelect(requestPostEntity);
        return requestPostEntity;
    }

    private final void checkBottomMargin() {
    }

    private final void checkCover(RequestPostMediaEntity mediaTypes) {
        Integer height;
        Integer width;
        Long size;
        if (this.coverPath != null) {
            MediaCoverEntity mediaCoverEntity = new MediaCoverEntity();
            CoverEntity coverEntity = this.coverPath;
            mediaCoverEntity.setUrl(coverEntity != null ? coverEntity.getUrl() : null);
            CoverEntity coverEntity2 = this.coverPath;
            mediaCoverEntity.setSize((coverEntity2 == null || (size = coverEntity2.getSize()) == null) ? 0L : size.longValue());
            CoverEntity coverEntity3 = this.coverPath;
            int i11 = 0;
            mediaCoverEntity.setWidth((coverEntity3 == null || (width = coverEntity3.getWidth()) == null) ? 0 : width.intValue());
            CoverEntity coverEntity4 = this.coverPath;
            if (coverEntity4 != null && (height = coverEntity4.getHeight()) != null) {
                i11 = height.intValue();
            }
            mediaCoverEntity.setHeight(i11);
            mediaTypes.setCover(mediaCoverEntity);
        }
    }

    private final boolean checkLogin() {
        ILoginApi loginApi = getLoginApi();
        if (loginApi == null || loginApi.a()) {
            return true;
        }
        androidx.activity.result.b bVar = this.loginLaunch;
        if (bVar == null) {
            this.isNeedShowLoginActivity = true;
        }
        if (bVar == null) {
            return false;
        }
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        Intent o11 = loginApi.o(requireContext);
        o11.putExtra("title_name", getString(R$string.post_login_title));
        bVar.a(o11);
        return false;
    }

    private final void checkVideoCover(RequestPostMediaEntity mediaTypes, VsMediaInfo vsMediaInfo) {
        if (TextUtils.isEmpty(vsMediaInfo.getImagePath())) {
            return;
        }
        int[] d11 = ImageUtils.d(vsMediaInfo.getImagePath());
        MediaCoverEntity mediaCoverEntity = new MediaCoverEntity();
        mediaCoverEntity.setUrl(vsMediaInfo.getImagePath());
        mediaCoverEntity.setSize(d11[0] * d11[1]);
        mediaCoverEntity.setWidth(d11[0]);
        mediaCoverEntity.setHeight(d11[1]);
        mediaTypes.setCover(mediaCoverEntity);
    }

    private final void clickPostTrace() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "post");
        hj.i.f64628a.p(getPageName(), hashMap);
    }

    private final void clickTrace(String value) {
        HashMap hashMap = new HashMap();
        hashMap.put("click", value);
        hj.i.f64628a.p(getPageName(), hashMap);
    }

    private final void coverClearDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.cover_clear_des);
            Intrinsics.g(string, "getString(...)");
            TRDialog.a g11 = aVar.g(string);
            String string2 = getString(R$string.cover_clear_left);
            Intrinsics.g(string2, "getString(...)");
            TRDialog.a e11 = g11.e(string2);
            String string3 = getString(R$string.cover_clear_right);
            Intrinsics.g(string3, "getString(...)");
            e11.j(string3).h(R$drawable.btn_bg_dialog_edit_selector).c(R$drawable.btn_bg_dialog_edit_selector).i(com.blankj.utilcode.util.h.a(com.transsion.baseui.R$color.base_color_black)).f(this).a().d0(this, "clear_cover");
        } catch (Exception unused) {
        }
    }

    private final void deleteAudio() {
        OperationBarView operationBarView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        LinearLayout linearLayout;
        ImageView imageView;
        ImageView imageView2;
        RelativeLayout relativeLayout3;
        RelativeLayout relativeLayout4;
        this.coverPath = null;
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (relativeLayout = mViewBinding.f64915o) != null && relativeLayout.getVisibility() == 0) {
            hp.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (relativeLayout4 = mViewBinding2.f64915o) != null) {
                relativeLayout4.setVisibility(8);
            }
            if (this.sourceType == 1) {
                hp.h mViewBinding3 = getMViewBinding();
                if (mViewBinding3 != null && (relativeLayout3 = mViewBinding3.f64917q) != null) {
                    relativeLayout3.setVisibility(0);
                }
            } else {
                hp.h mViewBinding4 = getMViewBinding();
                if (mViewBinding4 != null && (relativeLayout2 = mViewBinding4.f64917q) != null) {
                    relativeLayout2.setVisibility(8);
                }
            }
            hp.h mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (imageView2 = mViewBinding5.f64907g) != null) {
                imageView2.setImageResource(0);
            }
            hp.h mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (imageView = mViewBinding6.f64907g) != null) {
                imageView.setBackgroundResource(0);
            }
            hp.h mViewBinding7 = getMViewBinding();
            if (mViewBinding7 != null && (linearLayout = mViewBinding7.f64910j) != null) {
                linearLayout.requestLayout();
            }
        }
        hp.h mViewBinding8 = getMViewBinding();
        if (mViewBinding8 != null && (operationBarView = mViewBinding8.f64913m) != null) {
            operationBarView.resetItem();
        }
        fp.a aVar = this.operationMenu;
        if (aVar != null) {
            if ((aVar != null ? aVar.a() : null) != null) {
                com.transsion.publish.adapter.r rVar = this.managerAdapter;
                if (rVar != null) {
                    fp.a aVar2 = this.operationMenu;
                    AudioEntity a11 = aVar2 != null ? aVar2.a() : null;
                    Intrinsics.e(a11);
                    rVar.I(a11);
                }
                this.operationMenu = null;
            }
        }
        com.transsion.publish.adapter.r rVar2 = this.managerAdapter;
        if (rVar2 != null) {
            rVar2.u();
        }
    }

    private final void deleteLocation() {
        fp.a aVar = this.operationMenu;
        if (aVar != null) {
            if ((aVar != null ? aVar.g() : null) != null) {
                com.transsion.publish.adapter.r rVar = this.managerAdapter;
                if (rVar != null) {
                    fp.a aVar2 = this.operationMenu;
                    LocationPlace g11 = aVar2 != null ? aVar2.g() : null;
                    Intrinsics.e(g11);
                    rVar.I(g11);
                }
                this.locationBean = null;
                this.operationMenu = null;
            }
        }
    }

    private final void detectionSelect(RequestPostEntity request) {
        List<in.a> v11;
        List<VsMediaInfo> m11;
        List<PhotoEntity> m12;
        OperationBarView operationBarView;
        hp.h mViewBinding = getMViewBinding();
        List<Integer> selectItem = (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null) ? null : operationBarView.getSelectItem();
        RequestPostMediaEntity requestPostMediaEntity = new RequestPostMediaEntity();
        request.setMedia(requestPostMediaEntity);
        if (selectItem != null) {
            Iterator<T> it = selectItem.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (intValue == 0) {
                    requestPostMediaEntity.setMediaType(1);
                    ArrayList arrayList = new ArrayList();
                    com.transsion.publish.adapter.g gVar = this.imageAdapter;
                    if (gVar != null && (m12 = gVar.m()) != null) {
                        for (PhotoEntity photoEntity : m12) {
                            if (!photoEntity.getIsAdd()) {
                                MediaImageEntity mediaImageEntity = new MediaImageEntity();
                                mediaImageEntity.setUrl(String.valueOf(photoEntity.getLocalPath()));
                                if (photoEntity.getWidth() > 0) {
                                    mediaImageEntity.setWidth(Integer.valueOf(photoEntity.getWidth()));
                                }
                                if (photoEntity.getHeight() > 0) {
                                    mediaImageEntity.setHeight(Integer.valueOf(photoEntity.getHeight()));
                                }
                                if (photoEntity.getImageSize() > 0) {
                                    mediaImageEntity.setSize(Long.valueOf(photoEntity.getImageSize()));
                                }
                                arrayList.add(mediaImageEntity);
                            }
                        }
                    }
                    requestPostMediaEntity.setImage(arrayList);
                } else if (intValue == 1) {
                    requestPostMediaEntity.setMediaType(4);
                    requestPostMediaEntity.setVideo(new ArrayList());
                    com.transsion.publish.adapter.v vVar = this.videoAdapter;
                    if (vVar != null && (m11 = vVar.m()) != null) {
                        for (VsMediaInfo vsMediaInfo : m11) {
                            if (!vsMediaInfo.getIsAdd()) {
                                MediaVideoEntity mediaVideoEntity = new MediaVideoEntity();
                                mediaVideoEntity.setUrl(String.valueOf(vsMediaInfo.getVideoPath()));
                                mediaVideoEntity.setImagePath(vsMediaInfo.getImagePath());
                                if (vsMediaInfo.getWidth() > 0) {
                                    mediaVideoEntity.setWidth(vsMediaInfo.getWidth());
                                }
                                if (vsMediaInfo.getHeight() > 0) {
                                    mediaVideoEntity.setHeight(vsMediaInfo.getHeight());
                                }
                                if (vsMediaInfo.getVideoDuration() > 0) {
                                    mediaVideoEntity.setDuration(vsMediaInfo.getVideoDuration() / 1000);
                                }
                                mediaVideoEntity.setSize(vsMediaInfo.getVideoSize());
                                mediaVideoEntity.setFps(0);
                                mediaVideoEntity.setBitrate(0);
                                mediaVideoEntity.setDefinition(0);
                                List<MediaVideoEntity> video = requestPostMediaEntity.getVideo();
                                if (video != null) {
                                    video.add(mediaVideoEntity);
                                }
                                checkVideoCover(requestPostMediaEntity, vsMediaInfo);
                            }
                        }
                    }
                } else if (intValue == 2) {
                    requestPostMediaEntity.setMediaType(2);
                    requestPostMediaEntity.setAudio(new ArrayList());
                    com.transsion.publish.adapter.r rVar = this.managerAdapter;
                    if (rVar != null && (v11 = rVar.v()) != null) {
                        for (in.a aVar : v11) {
                            if (aVar instanceof AudioEntity) {
                                MediaAudioEntity mediaAudioEntity = new MediaAudioEntity();
                                AudioEntity audioEntity = (AudioEntity) aVar;
                                mediaAudioEntity.setUrl(String.valueOf(audioEntity.getLocalPath()));
                                mediaAudioEntity.setSize(audioEntity.getSize());
                                Long duration = audioEntity.getDuration();
                                if ((duration != null ? duration.longValue() : 0L) > 0) {
                                    Long duration2 = audioEntity.getDuration();
                                    mediaAudioEntity.setDuration(duration2 != null ? duration2.longValue() / 1000 : 0L);
                                }
                                mediaAudioEntity.setBitrate(0L);
                                List<MediaAudioEntity> audio = requestPostMediaEntity.getAudio();
                                if (audio != null) {
                                    audio.add(mediaAudioEntity);
                                }
                            }
                        }
                    }
                    checkCover(requestPostMediaEntity);
                }
            }
        }
    }

    private final void disposeOperate(fp.a it) {
        Integer e11;
        this.operationMenu = it;
        hideOpertaionDialog();
        Integer e12 = it.e();
        if (e12 != null && e12.intValue() == 0) {
            refreshImage(it);
        } else if (e12 != null && e12.intValue() == 1) {
            refreshVideo(it);
        } else if (e12 != null && e12.intValue() == 2) {
            refreshAudio(it);
        } else if (e12 != null && e12.intValue() == 5) {
            refreshCover(it);
        } else if (e12 != null && e12.intValue() == 3) {
            refreshWork(it);
        } else if (e12 != null && e12.intValue() == 6) {
            refreshGroup(it);
        } else if (e12 != null && e12.intValue() == 4) {
            refreshLink(it);
        } else if (e12 != null && e12.intValue() == 8) {
            refreshLocation(it);
        }
        Integer e13 = it.e();
        if (e13 != null && e13.intValue() == 5 && (e11 = it.e()) != null && e11.intValue() == 6) {
            return;
        }
        checkBottomMargin();
    }

    private final List<PhotoEntity> getAddImageEntity() {
        ArrayList arrayList = new ArrayList();
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setAdd(true);
        arrayList.add(photoEntity);
        return arrayList;
    }

    private final List<VsMediaInfo> getAddVideoEntity() {
        ArrayList arrayList = new ArrayList();
        VsMediaInfo vsMediaInfo = new VsMediaInfo();
        vsMediaInfo.setAdd(true);
        arrayList.add(vsMediaInfo);
        return arrayList;
    }

    private final void getImageIconView() {
        OperationBarView operationBarView;
        RecyclerView recyclerView;
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null || (recyclerView = operationBarView.getCom.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_TEMPLATE java.lang.String()) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.publish.ui.l
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.getImageIconView$lambda$11(FilmReviewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getImageIconView$lambda$11(FilmReviewFragment filmReviewFragment) {
        OperationBarView operationBarView;
        RecyclerView recyclerView;
        hp.h mViewBinding = filmReviewFragment.getMViewBinding();
        RecyclerView.b0 findViewHolderForAdapterPosition = (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null || (recyclerView = operationBarView.getCom.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_TEMPLATE java.lang.String()) == null) ? null : recyclerView.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition instanceof op.f) {
            filmReviewFragment.imageIcon = (ImageView) ((op.f) findViewHolderForAdapterPosition).itemView.findViewById(R$id.image);
        }
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.loginApi.getValue();
    }

    private final IRoomApi getMRoomApi() {
        return (IRoomApi) this.mRoomApi.getValue();
    }

    private final String getPageName() {
        return PAGE_NAME;
    }

    private final kp.b getPublishModel() {
        return (kp.b) this.publishModel.getValue();
    }

    private final void getVideoIconView() {
        OperationBarView operationBarView;
        RecyclerView recyclerView;
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null || (recyclerView = operationBarView.getCom.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_TEMPLATE java.lang.String()) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.publish.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.getVideoIconView$lambda$10(FilmReviewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getVideoIconView$lambda$10(FilmReviewFragment filmReviewFragment) {
        OperationBarView operationBarView;
        RecyclerView recyclerView;
        hp.h mViewBinding = filmReviewFragment.getMViewBinding();
        RecyclerView.b0 findViewHolderForAdapterPosition = (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null || (recyclerView = operationBarView.getCom.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_TEMPLATE java.lang.String()) == null) ? null : recyclerView.findViewHolderForAdapterPosition(1);
        if (findViewHolderForAdapterPosition instanceof op.f) {
            filmReviewFragment.videoIcon = (ImageView) ((op.f) findViewHolderForAdapterPosition).itemView.findViewById(R$id.image);
        }
    }

    private final void hideOpertaionDialog() {
    }

    private final void initImageAdapter() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (this.imageAdapter == null) {
            this.imageAdapter = new com.transsion.publish.adapter.g();
            hp.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView3 = mViewBinding.f64919s) != null) {
                recyclerView3.setLayoutManager(new NpaGridLayoutManager(getContext(), 3));
            }
            hp.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView2 = mViewBinding2.f64919s) != null) {
                recyclerView2.addItemDecoration(new ig.b(com.blankj.utilcode.util.a0.a(2.0f), com.blankj.utilcode.util.a0.a(2.0f), 0, com.blankj.utilcode.util.a0.a(8.0f)));
            }
        }
        hp.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (recyclerView = mViewBinding3.f64919s) == null) {
            return;
        }
        recyclerView.setAdapter(this.imageAdapter);
    }

    private final void initManagerAdapter() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (this.managerAdapter == null) {
            this.managerAdapter = new com.transsion.publish.adapter.r();
            hp.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView2 = mViewBinding.f64918r) != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
            }
            hp.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 == null || (recyclerView = mViewBinding2.f64918r) == null) {
                return;
            }
            recyclerView.setAdapter(this.managerAdapter);
        }
    }

    private final void initRegisterMediaSelector() {
        if (this.underOS33) {
            return;
        }
        this.videoSelectLauncher = requireActivity().registerForActivityResult(new f.g(), new androidx.activity.result.a() { // from class: com.transsion.publish.ui.t
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                FilmReviewFragment.initRegisterMediaSelector$lambda$31(FilmReviewFragment.this, (Uri) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRegisterMediaSelector$lambda$31(FilmReviewFragment filmReviewFragment, Uri uri) {
        if (uri != null) {
            fp.a aVar = new fp.a();
            aVar.o(1);
            aVar.n(1);
            VsMediaInfo vsMediaInfo = new VsMediaInfo();
            mp.g gVar = mp.g.f69804a;
            Context requireContext = filmReviewFragment.requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            gp.a b11 = gVar.b(requireContext, uri);
            if (b11 != null) {
                vsMediaInfo.setVideoPath(b11.c());
                vsMediaInfo.setVideoTitle(b11.e());
                vsMediaInfo.setVideoDuration(b11.a());
                vsMediaInfo.setWidth(b11.f());
                vsMediaInfo.setHeight(b11.b());
                vsMediaInfo.setVideoSize(b11.d());
            }
            aVar.u(vsMediaInfo);
            filmReviewFragment.refreshVideo(aVar);
            filmReviewFragment.requireActivity().getContentResolver().takePersistableUriPermission(uri, 1);
        }
    }

    private final void initVideoAdapter() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        if (this.videoAdapter == null) {
            this.videoAdapter = new com.transsion.publish.adapter.v();
            hp.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (recyclerView3 = mViewBinding.f64919s) != null) {
                recyclerView3.setLayoutManager(new NpaGridLayoutManager(getContext(), 3));
            }
            hp.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (recyclerView2 = mViewBinding2.f64919s) != null) {
                recyclerView2.addItemDecoration(new ig.b(com.blankj.utilcode.util.a0.a(2.0f), com.blankj.utilcode.util.a0.a(2.0f), 0, com.blankj.utilcode.util.a0.a(8.0f)));
            }
        }
        hp.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (recyclerView = mViewBinding3.f64919s) == null) {
            return;
        }
        recyclerView.setAdapter(this.videoAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(FilmReviewFragment filmReviewFragment, RatingBar ratingBar, float f11, boolean z10) {
        filmReviewFragment.postStar = (int) f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(FilmReviewFragment filmReviewFragment, View view) {
        SelectImageActivity.Companion companion = SelectImageActivity.INSTANCE;
        Context requireContext = filmReviewFragment.requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        com.transsion.publish.adapter.g gVar = filmReviewFragment.imageAdapter;
        companion.a(requireContext, 5, 1, gVar != null ? gVar.m() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(FilmReviewFragment filmReviewFragment, ActivityResult it) {
        Intrinsics.h(it, "it");
        if (it.getResultCode() != -1) {
            a.C0856a.f(lg.a.f68962a, "loginStatus", "登录失败或者取消", false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "loginStatus", "登录成功", false, 4, null);
        com.tn.lib.widget.toast.core.h hVar = com.tn.lib.widget.toast.core.h.f41533a;
        ILoginApi loginApi = filmReviewFragment.getLoginApi();
        hVar.l(loginApi != null ? loginApi.b() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(FilmReviewFragment filmReviewFragment, View view, boolean z10) {
        view.dispatchWindowFocusChanged(z10);
        filmReviewFragment.hasFocus = z10;
        if (z10) {
            filmReviewFragment.hideOpertaionDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(final FilmReviewFragment filmReviewFragment, View view, boolean z10) {
        hp.h mViewBinding;
        EditText editText;
        EditText editText2;
        view.dispatchWindowFocusChanged(z10);
        if (z10) {
            filmReviewFragment.hideOpertaionDialog();
            hp.h mViewBinding2 = filmReviewFragment.getMViewBinding();
            if (!TextUtils.isEmpty((mViewBinding2 == null || (editText2 = mViewBinding2.f64903c) == null) ? null : editText2.getText()) || (mViewBinding = filmReviewFragment.getMViewBinding()) == null || (editText = mViewBinding.f64903c) == null) {
                return;
            }
            editText.post(new Runnable() { // from class: com.transsion.publish.ui.v
                @Override // java.lang.Runnable
                public final void run() {
                    FilmReviewFragment.initView$lambda$8$lambda$7(FilmReviewFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8$lambda$7(FilmReviewFragment filmReviewFragment) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        hp.h mViewBinding = filmReviewFragment.getMViewBinding();
        if (mViewBinding != null && (editText3 = mViewBinding.f64903c) != null) {
            editText3.setText("");
        }
        hp.h mViewBinding2 = filmReviewFragment.getMViewBinding();
        if (mViewBinding2 != null && (editText2 = mViewBinding2.f64903c) != null) {
            editText2.setSelection(0);
        }
        hp.h mViewBinding3 = filmReviewFragment.getMViewBinding();
        if (mViewBinding3 == null || (editText = mViewBinding3.f64903c) == null) {
            return;
        }
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(int i11) {
    }

    @SuppressLint({"InflateParams"})
    private final void initViewModel() {
        observe();
    }

    private final boolean isMoreThanADay(long timestamp1, long timestamp2) {
        return timestamp1 - timestamp2 > ((long) MiniAppConfigHelper.DEFAULT_MINI_SCOPE_REQUEST_DIFF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi loginApi_delegate$lambda$1() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IRoomApi mRoomApi_delegate$lambda$0() {
        return (IRoomApi) TheRouter.d(IRoomApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnable$lambda$36(FilmReviewFragment filmReviewFragment) {
        EditText editText;
        hp.h mViewBinding = filmReviewFragment.getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f64903c) == null) {
            return;
        }
        editText.clearFocus();
        editText.requestFocus();
        KeyboardUtils.i(editText);
    }

    private final void observe() {
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observe$lambda$23;
                observe$lambda$23 = FilmReviewFragment.observe$lambda$23(FilmReviewFragment.this, (fp.a) obj);
                return observe$lambda$23;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = fp.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsion.publish.ui.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observe$lambda$24;
                observe$lambda$24 = FilmReviewFragment.observe$lambda$24(FilmReviewFragment.this, (BigImageBean) obj);
                return observe$lambda$24;
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = BigImageBean.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$23(FilmReviewFragment filmReviewFragment, fp.a it) {
        Intrinsics.h(it, "it");
        filmReviewFragment.disposeOperate(it);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$24(FilmReviewFragment filmReviewFragment, BigImageBean it) {
        Intrinsics.h(it, "it");
        Integer from = it.getFrom();
        if (from == null || from.intValue() != 2) {
            return Unit.f67184a;
        }
        Integer operator = it.getOperator();
        if (operator != null && operator.intValue() == 1) {
            filmReviewFragment.selectPhotosDispose(it.getSelect());
        }
        return Unit.f67184a;
    }

    private final void openRoomList() {
        Navigator.x(TheRouter.c("/room/list").z("is_select_room", true).F("index", 1), requireContext(), null, 2, null);
    }

    private final void postService(RequestPostEntity request, int source) {
        PublishService.Companion companion = PublishService.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        companion.a(requireContext, request, this.sourceType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp.b publishModel_delegate$lambda$2() {
        return new kp.b();
    }

    private final void refreshAudio(fp.a it) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        OperationBarView operationBarView;
        Integer d11 = it.d();
        if (d11 == null || d11.intValue() != 1) {
            if (d11 != null && d11.intValue() == 2) {
                if (this.coverPath != null) {
                    coverClearDialog();
                    return;
                } else {
                    deleteAudio();
                    return;
                }
            }
            return;
        }
        if (it.a() == null) {
            return;
        }
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (operationBarView = mViewBinding.f64913m) != null) {
            operationBarView.selectItem(2);
        }
        initManagerAdapter();
        AudioEntity a11 = it.a();
        if (a11 != null) {
            a11.setType(2);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(it.a());
        }
        hp.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (relativeLayout3 = mViewBinding2.f64915o) == null || relativeLayout3.getVisibility() != 0) {
            hp.h mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (relativeLayout2 = mViewBinding3.f64915o) != null) {
                relativeLayout2.setVisibility(0);
            }
            hp.h mViewBinding4 = getMViewBinding();
            if (mViewBinding4 == null || (relativeLayout = mViewBinding4.f64917q) == null) {
                return;
            }
            relativeLayout.setVisibility(8);
        }
    }

    private final void refreshCover(fp.a it) {
        ImageView imageView;
        if (it.b() == null) {
            return;
        }
        if (this.coverPath == null) {
            this.coverPath = new CoverEntity();
        }
        CoverEntity coverEntity = this.coverPath;
        if (coverEntity != null) {
            PhotoEntity b11 = it.b();
            coverEntity.setUrl(b11 != null ? b11.getLocalPath() : null);
        }
        CoverEntity coverEntity2 = this.coverPath;
        if (coverEntity2 != null) {
            PhotoEntity b12 = it.b();
            coverEntity2.setSize(b12 != null ? Long.valueOf(b12.getImageSize()) : null);
        }
        CoverEntity coverEntity3 = this.coverPath;
        if (coverEntity3 != null) {
            PhotoEntity b13 = it.b();
            coverEntity3.setWidth(b13 != null ? Integer.valueOf(b13.getWidth()) : null);
        }
        CoverEntity coverEntity4 = this.coverPath;
        if (coverEntity4 != null) {
            PhotoEntity b14 = it.b();
            coverEntity4.setHeight(b14 != null ? Integer.valueOf(b14.getHeight()) : null);
        }
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (imageView = mViewBinding.f64907g) != null) {
            imageView.setVisibility(0);
        }
        f.a aVar = ej.f.f62005a;
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        f.b m11 = aVar.m(requireContext);
        PhotoEntity b15 = it.b();
        f.b i11 = m11.g(b15 != null ? b15.getLocalPath() : null).i(com.transsion.publish.R$color.color_ff999999);
        hp.h mViewBinding2 = getMViewBinding();
        ImageView imageView2 = mViewBinding2 != null ? mViewBinding2.f64907g : null;
        Intrinsics.e(imageView2);
        i11.d(imageView2);
    }

    private final void refreshGroup(fp.a it) {
        this.groupBean = it.c();
        Integer d11 = it.d();
        if (d11 != null && d11.intValue() == 1) {
            GroupBean c11 = it.c();
            if (c11 != null) {
                setGroup(c11);
            }
        } else if (d11 != null && d11.intValue() == 2) {
            fp.a aVar = this.operationMenu;
            if (aVar != null) {
                if ((aVar != null ? aVar.c() : null) != null) {
                    com.transsion.publish.adapter.r rVar = this.managerAdapter;
                    if (rVar != null) {
                        fp.a aVar2 = this.operationMenu;
                        GroupBean c12 = aVar2 != null ? aVar2.c() : null;
                        Intrinsics.e(c12);
                        rVar.I(c12);
                    }
                    this.operationMenu = null;
                }
            }
            this.groupBean = null;
        }
        HashMap hashMap = new HashMap();
        GroupBean groupBean = this.groupBean;
        hashMap.put("group_id", String.valueOf(groupBean != null ? groupBean.getGroupId() : null));
        hj.i.f64628a.p(getPageName(), hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0098, code lost:
    
        if (((r5 == null || (r5 = r5.l()) == null || (r5 = (com.transsion.publish.api.PhotoEntity) r5.get(0)) == null || !r5.getIsAdd()) ? false : true) != false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void refreshImage(fp.a r5) {
        /*
            r4 = this;
            java.lang.Integer r0 = r5.d()
            r1 = 9
            r2 = 0
            r3 = 1
            if (r0 != 0) goto Lb
            goto L45
        Lb:
            int r0 = r0.intValue()
            if (r0 != r3) goto L45
            com.transsion.publish.adapter.g r0 = r4.imageAdapter
            if (r0 == 0) goto L1f
            java.util.List r0 = r0.l()
            if (r0 == 0) goto L1f
            int r2 = r0.size()
        L1f:
            if (r2 >= r1) goto Lcc
            com.transsion.publish.adapter.g r0 = r4.imageAdapter
            if (r0 == 0) goto L3c
            java.util.List r1 = r5.h()
            if (r1 != 0) goto L30
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L30:
            java.util.List r0 = r0.l()
            java.util.Collection r0 = (java.util.Collection) r0
            r1.addAll(r0)
            r5.r(r1)
        L3c:
            java.util.List r5 = r5.h()
            r4.selectPhotosDispose(r5)
            goto Lcc
        L45:
            java.lang.Integer r5 = r5.d()
            if (r5 != 0) goto L4d
            goto Lcc
        L4d:
            int r5 = r5.intValue()
            r0 = 2
            if (r5 != r0) goto Lcc
            com.transsion.publish.adapter.g r5 = r4.imageAdapter
            if (r5 == 0) goto L66
            java.util.List r5 = r5.l()
            if (r5 == 0) goto L66
            int r5 = r5.size()
            if (r5 != 0) goto L66
            r5 = r3
            goto L67
        L66:
            r5 = r2
        L67:
            if (r5 != 0) goto Lbd
            com.transsion.publish.adapter.g r5 = r4.imageAdapter
            if (r5 == 0) goto L7b
            java.util.List r5 = r5.l()
            if (r5 == 0) goto L7b
            int r5 = r5.size()
            if (r5 != r3) goto L7b
            r5 = r3
            goto L7c
        L7b:
            r5 = r2
        L7c:
            if (r5 == 0) goto L9b
            com.transsion.publish.adapter.g r5 = r4.imageAdapter
            if (r5 == 0) goto L97
            java.util.List r5 = r5.l()
            if (r5 == 0) goto L97
            java.lang.Object r5 = r5.get(r2)
            com.transsion.publish.api.PhotoEntity r5 = (com.transsion.publish.api.PhotoEntity) r5
            if (r5 == 0) goto L97
            boolean r5 = r5.getIsAdd()
            if (r5 != r3) goto L97
            goto L98
        L97:
            r3 = r2
        L98:
            if (r3 == 0) goto L9b
            goto Lbd
        L9b:
            com.transsion.publish.adapter.g r5 = r4.imageAdapter
            if (r5 == 0) goto Laa
            java.util.List r5 = r5.l()
            if (r5 == 0) goto Laa
            int r5 = r5.size()
            goto Lab
        Laa:
            r5 = r2
        Lab:
            if (r5 >= r1) goto Lcc
            g4.a r5 = r4.getMViewBinding()
            hp.h r5 = (hp.h) r5
            if (r5 == 0) goto Lcc
            com.transsion.publish.view.operation.OperationBarView r5 = r5.f64913m
            if (r5 == 0) goto Lcc
            r5.selectItem(r2)
            goto Lcc
        Lbd:
            g4.a r5 = r4.getMViewBinding()
            hp.h r5 = (hp.h) r5
            if (r5 == 0) goto Lcc
            com.transsion.publish.view.operation.OperationBarView r5 = r5.f64913m
            if (r5 == 0) goto Lcc
            r5.resetItem()
        Lcc:
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()
            java.lang.String r0 = "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            com.transsion.publish.ui.FilmReviewActivity r5 = (com.transsion.publish.ui.FilmReviewActivity) r5
            boolean r0 = r4.isPostEnable()
            r5.m0(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.publish.ui.FilmReviewFragment.refreshImage(fp.a):void");
    }

    private final void refreshLink(fp.a it) {
        hp.h mViewBinding;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        Integer d11 = it.d();
        if (d11 == null || d11.intValue() != 1) {
            if (d11 == null || d11.intValue() != 2 || (mViewBinding = getMViewBinding()) == null || (operationBarView = mViewBinding.f64913m) == null) {
                return;
            }
            operationBarView.resetItem(true);
            return;
        }
        if (it.f() == null) {
            return;
        }
        hp.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (operationBarView2 = mViewBinding2.f64913m) != null) {
            operationBarView2.selectItem(4);
        }
        initManagerAdapter();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(it.f());
        }
        LinkEntity f11 = it.f();
        this.linkEntity = new MediaLinkEntity(f11 != null ? f11.getUrl() : null, f11 != null ? f11.getTitle() : null, f11 != null ? f11.getCover() : null);
        LinkEntity f12 = it.f();
        if (f12 == null || !f12.getLoading()) {
            return;
        }
        com.tn.lib.widget.toast.core.h.f41533a.k(R$string.postint_state_added);
    }

    private final void refreshLocation(fp.a it) {
        OperationBarView operationBarView;
        this.locationBean = it.g();
        Integer d11 = it.d();
        if (d11 == null || d11.intValue() != 1) {
            if (d11 != null && d11.intValue() == 2) {
                deleteLocation();
                return;
            }
            return;
        }
        if (it.g() == null) {
            return;
        }
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (operationBarView = mViewBinding.f64913m) != null) {
            operationBarView.selectItem(8);
        }
        initManagerAdapter();
        LocationPlace g11 = it.g();
        if (g11 != null) {
            g11.setType(8);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(it.g());
        }
    }

    private final void refreshVideo(fp.a it) {
        OperationBarView operationBarView;
        ImageView imageView;
        List l11;
        OperationBarView operationBarView2;
        Integer d11 = it.d();
        if (d11 != null && d11.intValue() == 1) {
            if (it.j() == null) {
                return;
            }
            VsMediaInfo j11 = it.j();
            if ((j11 != null ? j11.getVideoDuration() : 0L) > 600000) {
                com.tn.lib.widget.toast.core.h.f41533a.l(getString(R$string.publish_video_limit));
                return;
            }
            initVideoAdapter();
            ArrayList arrayList = new ArrayList();
            VsMediaInfo j12 = it.j();
            Intrinsics.e(j12);
            arrayList.add(j12);
            com.transsion.publish.adapter.v vVar = this.videoAdapter;
            if (vVar != null) {
                vVar.setData(arrayList);
            }
            hp.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (operationBarView2 = mViewBinding.f64913m) != null) {
                operationBarView2.selectItem(1);
            }
            com.transsion.publish.adapter.v vVar2 = this.videoAdapter;
            if (((vVar2 == null || (l11 = vVar2.l()) == null) ? 0 : l11.size()) >= 1 && (imageView = this.videoIcon) != null) {
                imageView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilmReviewFragment.refreshVideo$lambda$27(FilmReviewFragment.this);
                    }
                }, 200L);
            }
        } else if (d11 != null && d11.intValue() == 2) {
            this.coverPath = null;
            com.transsion.publish.adapter.v vVar3 = this.videoAdapter;
            if (vVar3 != null) {
                vVar3.t();
            }
            hp.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (operationBarView = mViewBinding2.f64913m) != null) {
                operationBarView.resetItem();
            }
        }
        FragmentActivity activity = getActivity();
        Intrinsics.f(activity, "null cannot be cast to non-null type com.transsion.publish.ui.FilmReviewActivity");
        ((FilmReviewActivity) activity).m0(isPostEnable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshVideo$lambda$27(FilmReviewFragment filmReviewFragment) {
        ImageView imageView = filmReviewFragment.videoIcon;
        if (imageView != null) {
            imageView.setImageResource(R$drawable.icon_post_video_unable);
        }
    }

    private final void refreshWork(fp.a it) {
        com.transsion.publish.adapter.g gVar;
        com.transsion.publish.adapter.v vVar;
        hp.h mViewBinding;
        OperationBarView operationBarView;
        String str;
        this.mSubject = it.i();
        Integer d11 = it.d();
        if (d11 != null && d11.intValue() == 1) {
            Subject i11 = it.i();
            if (i11 != null) {
                setSubject(i11);
            }
            HashMap hashMap = new HashMap();
            Subject i12 = it.i();
            if (i12 == null || (str = i12.getSubjectId()) == null) {
                str = "";
            }
            hashMap.put("subject_id", str);
            hj.i.f64628a.p(getPageName(), hashMap);
            return;
        }
        if (d11 == null || d11.intValue() != 2 || (gVar = this.imageAdapter) == null || !gVar.n() || (vVar = this.videoAdapter) == null || !vVar.n() || (mViewBinding = getMViewBinding()) == null || (operationBarView = mViewBinding.f64913m) == null) {
            return;
        }
        operationBarView.resetItem();
    }

    private final void requestCurrentLocation() {
        IRoomApi mRoomApi;
        FragmentActivity activity = getActivity();
        if (activity == null || !ye.c.f79116a.f(activity, "android.permission.ACCESS_FINE_LOCATION") || (mRoomApi = getMRoomApi()) == null) {
            return;
        }
        mRoomApi.b(activity, new Function1() { // from class: com.transsion.publish.ui.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit requestCurrentLocation$lambda$15;
                requestCurrentLocation$lambda$15 = FilmReviewFragment.requestCurrentLocation$lambda$15(FilmReviewFragment.this, (LocationPlace) obj);
                return requestCurrentLocation$lambda$15;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestCurrentLocation$lambda$15(FilmReviewFragment filmReviewFragment, LocationPlace locationPlace) {
        String name = locationPlace != null ? locationPlace.getName() : null;
        if (name == null || name.length() == 0) {
            return Unit.f67184a;
        }
        filmReviewFragment.setLocation(locationPlace);
        return Unit.f67184a;
    }

    private final void selectPhotosDispose(List<PhotoEntity> photoEntity) {
        OperationBarView operationBarView;
        ImageView imageView;
        List l11;
        OperationBarView operationBarView2;
        com.transsion.publish.adapter.g gVar;
        List<PhotoEntity> list = photoEntity;
        if (list == null || list.isEmpty()) {
            com.transsion.publish.adapter.g gVar2 = this.imageAdapter;
            if (gVar2 == null) {
                initImageAdapter();
                return;
            }
            if (gVar2 != null) {
                gVar2.u();
            }
            hp.h mViewBinding = getMViewBinding();
            if (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null) {
                return;
            }
            operationBarView.resetItem();
            return;
        }
        initImageAdapter();
        com.transsion.publish.adapter.g gVar3 = this.imageAdapter;
        if (gVar3 != null) {
            if (photoEntity == null) {
                photoEntity = new ArrayList<>();
            }
            gVar3.setData(photoEntity);
        }
        com.transsion.publish.adapter.g gVar4 = this.imageAdapter;
        if ((gVar4 != null ? gVar4.getItemCount() : 0) < 9 && (gVar = this.imageAdapter) != null) {
            gVar.addData(getAddImageEntity());
        }
        hp.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (operationBarView2 = mViewBinding2.f64913m) != null) {
            operationBarView2.selectItem(0);
        }
        com.transsion.publish.adapter.g gVar5 = this.imageAdapter;
        Integer valueOf = (gVar5 == null || (l11 = gVar5.l()) == null) ? null : Integer.valueOf(l11.size());
        Intrinsics.e(valueOf);
        if (valueOf.intValue() < 9 || (imageView = this.imageIcon) == null) {
            return;
        }
        imageView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.u
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.selectPhotosDispose$lambda$26(FilmReviewFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectPhotosDispose$lambda$26(FilmReviewFragment filmReviewFragment) {
        ImageView imageView = filmReviewFragment.imageIcon;
        if (imageView != null) {
            imageView.setImageResource(R$drawable.icon_post_select_image_unable);
        }
    }

    private final void setGroup(GroupBean groupBean) {
        if (groupBean == null) {
            return;
        }
        initManagerAdapter();
        groupBean.setType(6);
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(groupBean);
        }
    }

    private final void setLocation(LocationPlace location) {
        this.locationBean = location;
        this.curLocationBean = location;
        initManagerAdapter();
        if (location != null) {
            location.setType(8);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(location);
        }
    }

    private final void setStarTips(int text) {
        TextView textView;
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (textView = mViewBinding.f64922v) == null) {
            return;
        }
        textView.setText(text);
    }

    private final void setSubject(Subject subject) {
        if (subject == null) {
            return;
        }
        initManagerAdapter();
        subject.setType(3);
        if (this.sourceType == 1) {
            subject.setCorrelation(true);
        }
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.J(subject);
        }
    }

    private final void showActivityTips() {
        BubbleTextView bubbleTextView;
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleTextView = mViewBinding.f64902b) == null) {
            return;
        }
        bubbleTextView.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.r
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.showActivityTips$lambda$14(FilmReviewFragment.this);
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivityTips$lambda$14(final FilmReviewFragment filmReviewFragment) {
        OperationBarView operationBarView;
        RecyclerView recyclerView;
        if (filmReviewFragment.isMoreThanADay(System.currentTimeMillis(), com.transsion.baselib.report.launch.b.f43424a.b().getLong("publish_show_guide_time", 0L))) {
            if (filmReviewFragment.groupBean == null && filmReviewFragment.mSubject == null && filmReviewFragment.locationBean != null) {
                return;
            }
            if (filmReviewFragment.mSubject != null || filmReviewFragment.locationBean == null) {
                final d dVar = new d();
                hp.h mViewBinding = filmReviewFragment.getMViewBinding();
                if (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null || (recyclerView = operationBarView.getCom.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_TEMPLATE java.lang.String()) == null) {
                    return;
                }
                recyclerView.post(new Runnable() { // from class: com.transsion.publish.ui.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilmReviewFragment.showActivityTips$lambda$14$lambda$13(FilmReviewFragment.this, dVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showActivityTips$lambda$14$lambda$13(FilmReviewFragment filmReviewFragment, d dVar) {
        float f11;
        BubbleTextView bubbleTextView;
        OperationBarView operationBarView;
        RecyclerView recyclerView;
        if (!filmReviewFragment.isAdded() || filmReviewFragment.isDetached() || filmReviewFragment.isRemoving()) {
            return;
        }
        String string = filmReviewFragment.getString(R$string.publish_tip_text);
        Intrinsics.g(string, "getString(...)");
        GroupBean groupBean = filmReviewFragment.groupBean;
        int i11 = 3;
        if (groupBean == null && filmReviewFragment.mSubject == null) {
            string = filmReviewFragment.getString(R$string.publish_tip_text);
            Intrinsics.g(string, "getString(...)");
            f11 = 30.0f;
        } else {
            if (filmReviewFragment.mSubject == null) {
                string = filmReviewFragment.getString(R$string.publish_tip_text_no_subject);
                Intrinsics.g(string, "getString(...)");
            } else if (groupBean == null) {
                string = filmReviewFragment.getString(R$string.publish_tip_text_no_group);
                Intrinsics.g(string, "getString(...)");
                i11 = 2;
            } else {
                f11 = 0.0f;
                i11 = 0;
            }
            f11 = 6.0f;
        }
        hp.h mViewBinding = filmReviewFragment.getMViewBinding();
        View childAt = (mViewBinding == null || (operationBarView = mViewBinding.f64913m) == null || (recyclerView = operationBarView.getCom.mbridge.msdk.foundation.entity.CampaignEx.JSON_KEY_REWARD_TEMPLATE java.lang.String()) == null) ? null : recyclerView.getChildAt(i11);
        int[] iArr = new int[2];
        if (childAt != null) {
            childAt.getLocationOnScreen(iArr);
        }
        hp.h mViewBinding2 = filmReviewFragment.getMViewBinding();
        if (mViewBinding2 == null || (bubbleTextView = mViewBinding2.f64902b) == null) {
            return;
        }
        dVar.start();
        bubbleTextView.setVisibility(0);
        com.transsion.baselib.report.launch.b.f43424a.b().putLong("publish_show_guide_time", System.currentTimeMillis());
        bubbleTextView.setText(string);
        int i12 = iArr[0];
        oh.h hVar = oh.h.f71144a;
        Intrinsics.g(bubbleTextView.getContext(), "getContext(...)");
        bubbleTextView.setArrowPosition(i12 + hVar.a(r2, f11));
    }

    private final void showLinkEditInputDialog(Context context) {
        clickTrace("url");
        b.a aVar = new b.a(context);
        hp.h mViewBinding = getMViewBinding();
        ip.b a11 = aVar.a(this, mViewBinding != null ? mViewBinding.f64916p : null);
        a11.show();
        a11.setCancelable(true);
        a11.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLocation$lambda$33(Context context, FilmReviewFragment filmReviewFragment, boolean z10) {
        if (z10) {
            Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
            LocationPlace locationPlace = filmReviewFragment.curLocationBean;
            if (locationPlace != null) {
                intent.putExtra("location_data", locationPlace);
            }
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
        }
        return Unit.f67184a;
    }

    private final void userGrade() {
        com.transsion.publish.adapter.r rVar;
        com.transsion.publish.adapter.g gVar;
        com.transsion.publish.adapter.v vVar;
        RatingBar ratingBar;
        EditText editText;
        Editable text;
        this.publishType = 2;
        hp.h mViewBinding = getMViewBinding();
        Float f11 = null;
        if (TextUtils.isEmpty((mViewBinding == null || (editText = mViewBinding.f64903c) == null || (text = editText.getText()) == null) ? null : StringsKt.n1(text)) && (rVar = this.managerAdapter) != null && rVar.B() && (((gVar = this.imageAdapter) == null || (gVar != null && gVar.n())) && ((vVar = this.videoAdapter) == null || (vVar != null && vVar.n())))) {
            hp.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (ratingBar = mViewBinding2.f64914n) != null) {
                f11 = Float.valueOf(ratingBar.getRating());
            }
            Intrinsics.e(f11);
            if (f11.floatValue() > 0.0f && this.coverPath == null) {
                postService(buildRequest(), 2);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
        }
        if (checkLogin()) {
            postService(buildRequest(), 2);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    private final void userPost() {
        this.publishType = 1;
        if (checkLogin()) {
            postService(buildRequest(), 1);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void checkPost() {
        String w11;
        if (!nh.m.f70597a.e()) {
            com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.baseui.R$string.base_network_fail);
            return;
        }
        clickPostTrace();
        KeyboardUtils.d(requireActivity());
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null && (w11 = rVar.w()) != null) {
            ty.b.f76540a.a().i(1, w11);
        }
        int i11 = this.sourceType;
        if (i11 == 1) {
            userGrade();
        } else {
            if (i11 != 2) {
                return;
            }
            userPost();
        }
    }

    public final void closeAffirm() {
        EditText editText;
        Editable text;
        hp.h mViewBinding = getMViewBinding();
        boolean isEmpty = TextUtils.isEmpty((mViewBinding == null || (editText = mViewBinding.f64903c) == null || (text = editText.getText()) == null) ? null : StringsKt.n1(text));
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        boolean z10 = (rVar == null || rVar.A()) ? false : true;
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        boolean z11 = (gVar == null || gVar.n()) ? false : true;
        com.transsion.publish.adapter.v vVar = this.videoAdapter;
        boolean z12 = (vVar == null || vVar.n()) ? false : true;
        if (!isEmpty || z10 || z11 || z12) {
            backSaveDialog();
            return;
        }
        KeyboardUtils.d(requireActivity());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // ip.b.InterfaceC0821b
    public void completeLoad() {
        hp.h mViewBinding;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        hp.h mViewBinding2 = getMViewBinding();
        if ((mViewBinding2 != null && (operationBarView2 = mViewBinding2.f64913m) != null && operationBarView2.getVisibility() == 0) || (mViewBinding = getMViewBinding()) == null || (operationBarView = mViewBinding.f64913m) == null) {
            return;
        }
        jg.c.k(operationBarView);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hp.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        hp.h c11 = hp.h.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.graphics.Typeface, T] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.graphics.Typeface, T] */
    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        RelativeLayout relativeLayout;
        RatingBar ratingBar;
        TextView textView;
        RatingBar ratingBar2;
        ObservableScrollView observableScrollView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        EditText editText7;
        OperationBarView operationBarView;
        OperationBarView operationBarView2;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        RatingBar ratingBar3;
        TextView textView2;
        Intrinsics.h(view, "view");
        int i11 = this.sourceType;
        if (i11 == 1) {
            hp.h mViewBinding = getMViewBinding();
            if (mViewBinding != null && (ratingBar2 = mViewBinding.f64914n) != null) {
                ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.transsion.publish.ui.a0
                    @Override // android.widget.RatingBar.OnRatingBarChangeListener
                    public final void onRatingChanged(RatingBar ratingBar4, float f11, boolean z10) {
                        FilmReviewFragment.initView$lambda$3(FilmReviewFragment.this, ratingBar4, f11, z10);
                    }
                });
            }
            hp.h mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (textView = mViewBinding2.f64921u) != null) {
                textView.setVisibility(0);
            }
            hp.h mViewBinding3 = getMViewBinding();
            if (mViewBinding3 != null && (ratingBar = mViewBinding3.f64914n) != null) {
                ratingBar.setVisibility(0);
            }
            hp.h mViewBinding4 = getMViewBinding();
            if (mViewBinding4 != null && (relativeLayout = mViewBinding4.f64917q) != null) {
                relativeLayout.setVisibility(0);
            }
        } else if (i11 == 2) {
            hp.h mViewBinding5 = getMViewBinding();
            if (mViewBinding5 != null && (textView2 = mViewBinding5.f64921u) != null) {
                textView2.setVisibility(8);
            }
            hp.h mViewBinding6 = getMViewBinding();
            if (mViewBinding6 != null && (ratingBar3 = mViewBinding6.f64914n) != null) {
                ratingBar3.setVisibility(8);
            }
            hp.h mViewBinding7 = getMViewBinding();
            if (mViewBinding7 != null && (relativeLayout3 = mViewBinding7.f64917q) != null) {
                relativeLayout3.setVisibility(8);
            }
            hp.h mViewBinding8 = getMViewBinding();
            if (mViewBinding8 != null && (relativeLayout2 = mViewBinding8.f64915o) != null) {
                relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        FilmReviewFragment.initView$lambda$4(FilmReviewFragment.this, view2);
                    }
                });
            }
        }
        hp.h mViewBinding9 = getMViewBinding();
        if (mViewBinding9 != null && (operationBarView2 = mViewBinding9.f64913m) != null) {
            operationBarView2.setClickListener(this);
        }
        hp.h mViewBinding10 = getMViewBinding();
        if (mViewBinding10 != null && (operationBarView = mViewBinding10.f64913m) != null) {
            operationBarView.init(this.sourceType, this.groupBean, this.mSubject);
        }
        this.loginLaunch = registerForActivityResult(new f.j(), new androidx.activity.result.a() { // from class: com.transsion.publish.ui.c0
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                FilmReviewFragment.initView$lambda$5(FilmReviewFragment.this, (ActivityResult) obj);
            }
        });
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        hp.h mViewBinding11 = getMViewBinding();
        Typeface typeface = null;
        objectRef.element = Typeface.create((mViewBinding11 == null || (editText7 = mViewBinding11.f64904d) == null) ? null : editText7.getTypeface(), 1);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        hp.h mViewBinding12 = getMViewBinding();
        if (mViewBinding12 != null && (editText6 = mViewBinding12.f64904d) != null) {
            typeface = editText6.getTypeface();
        }
        objectRef2.element = Typeface.create(typeface, 0);
        hp.h mViewBinding13 = getMViewBinding();
        if (mViewBinding13 != null && (editText5 = mViewBinding13.f64904d) != null) {
            editText5.addTextChangedListener(new b(objectRef, objectRef2));
        }
        hp.h mViewBinding14 = getMViewBinding();
        if (mViewBinding14 != null && (editText4 = mViewBinding14.f64904d) != null) {
            editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.publish.ui.d0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z10) {
                    FilmReviewFragment.initView$lambda$6(FilmReviewFragment.this, view2, z10);
                }
            });
        }
        hp.h mViewBinding15 = getMViewBinding();
        if (mViewBinding15 != null && (editText3 = mViewBinding15.f64903c) != null) {
            editText3.addTextChangedListener(new c());
        }
        hp.h mViewBinding16 = getMViewBinding();
        if (mViewBinding16 != null && (editText2 = mViewBinding16.f64903c) != null) {
            editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.transsion.publish.ui.i
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z10) {
                    FilmReviewFragment.initView$lambda$8(FilmReviewFragment.this, view2, z10);
                }
            });
        }
        hp.h mViewBinding17 = getMViewBinding();
        if (mViewBinding17 != null && (editText = mViewBinding17.f64903c) != null) {
            editText.postDelayed(this.mRunnable, 500L);
        }
        hp.h mViewBinding18 = getMViewBinding();
        if (mViewBinding18 != null && (observableScrollView = mViewBinding18.f64920t) != null) {
            observableScrollView.setScrollListener(new ObservableScrollView.a() { // from class: com.transsion.publish.ui.j
                @Override // com.transsion.publish.view.ObservableScrollView.a
                public final void a(int i12) {
                    FilmReviewFragment.initView$lambda$9(i12);
                }
            });
        }
        requestCurrentLocation();
        showActivityTips();
        getVideoIconView();
        getImageIconView();
    }

    public final boolean isPostEnable() {
        com.transsion.publish.adapter.v vVar;
        hp.h mViewBinding;
        EditText editText;
        Editable text;
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        return ((gVar == null || gVar.n()) && ((vVar = this.videoAdapter) == null || vVar.n()) && ((mViewBinding = getMViewBinding()) == null || (editText = mViewBinding.f64903c) == null || (text = editText.getText()) == null || text.length() == 0)) ? false : true;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        return new hj.b(PAGE_NAME, false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.u();
        }
        MMKV I = MMKV.I("kv_link_record");
        Intrinsics.g(I, "mmkvWithID(...)");
        I.putString("link", "");
        a.C0856a.f(lg.a.f68962a, this.TAG, "FilmReviewFragment onDestroy", false, 4, null);
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.h(dialog, "dialog");
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        System.currentTimeMillis();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        FragmentActivity activity;
        Intrinsics.h(dialog, "dialog");
        String tag = dialog.getTag();
        if (tag != null) {
            int hashCode = tag.hashCode();
            if (hashCode == -1257717947) {
                if (tag.equals("clear_cover")) {
                    deleteAudio();
                }
            } else if (hashCode == 1335127509 && tag.equals("back_save") && (activity = getActivity()) != null) {
                activity.finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        com.transsion.publish.adapter.r rVar = this.managerAdapter;
        if (rVar != null) {
            rVar.H();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        Bundle arguments = getArguments();
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("sourceType", 2)) : null;
        Intrinsics.e(valueOf);
        this.sourceType = valueOf.intValue();
        Bundle arguments2 = getArguments();
        Integer valueOf2 = arguments2 != null ? Integer.valueOf(arguments2.getInt("sourceMode", 0)) : null;
        Intrinsics.e(valueOf2);
        this.sourceMode = valueOf2.intValue();
        Bundle arguments3 = getArguments();
        if (arguments3 != null && arguments3.containsKey("subject")) {
            Bundle arguments4 = getArguments();
            Serializable serializable = arguments4 != null ? arguments4.getSerializable("subject") : null;
            if (serializable != null && (serializable instanceof Subject)) {
                this.mSubject = (Subject) serializable;
            }
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null && arguments5.containsKey("group")) {
            Bundle arguments6 = getArguments();
            Serializable serializable2 = arguments6 != null ? arguments6.getSerializable("group") : null;
            if (serializable2 != null && (serializable2 instanceof GroupBean)) {
                this.groupBean = (GroupBean) serializable2;
            }
        }
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initRegisterMediaSelector();
        this.showTime = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, this.TAG, "FilmReviewFragment onViewCreated", false, 4, null);
    }

    @Override // com.transsion.publish.adapter.a
    public void put(Context context) {
        EditText editText;
        Intrinsics.h(context, "context");
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (editText = mViewBinding.f64903c) == null) {
            return;
        }
        KeyboardUtils.e(editText);
    }

    @Override // com.transsion.publish.adapter.a
    public void startAudio(Context context) {
        Intrinsics.h(context, "context");
        clickTrace(MimeTypes.BASE_TYPE_AUDIO);
        SelectMusicActivity.INSTANCE.a(context);
    }

    @Override // com.transsion.publish.adapter.a
    public void startGroup(Context context) {
        Intrinsics.h(context, "context");
        openRoomList();
    }

    @Override // com.transsion.publish.adapter.a
    public void startLink(Context context) {
        OperationVerticalBarView operationVerticalBarView;
        EditText editText;
        OperationBarView operationBarView;
        Intrinsics.h(context, "context");
        hp.h mViewBinding = getMViewBinding();
        if (mViewBinding == null || (operationVerticalBarView = mViewBinding.f64912l) == null || operationVerticalBarView.getVisibility() != 0) {
            showLinkEditInputDialog(context);
            return;
        }
        hp.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (operationBarView = mViewBinding2.f64913m) != null) {
            jg.c.g(operationBarView);
        }
        hideOpertaionDialog();
        showLinkEditInputDialog(context);
        hp.h mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (editText = mViewBinding3.f64903c) == null) {
            return;
        }
        editText.postDelayed(new Runnable() { // from class: com.transsion.publish.ui.y
            @Override // java.lang.Runnable
            public final void run() {
                FilmReviewFragment.this.completeLoad();
            }
        }, 2000L);
    }

    @Override // com.transsion.publish.adapter.a
    public void startLocation(final Context context) {
        Intrinsics.h(context, "context");
        FragmentActivity activity = getActivity();
        if (activity == null || !isAdded() || isDetached() || isRemoving()) {
            return;
        }
        if (!ye.c.f79116a.f(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            IRoomApi mRoomApi = getMRoomApi();
            if (mRoomApi != null) {
                mRoomApi.a(activity, true, new Function1() { // from class: com.transsion.publish.ui.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit startLocation$lambda$33;
                        startLocation$lambda$33 = FilmReviewFragment.startLocation$lambda$33(context, this, ((Boolean) obj).booleanValue());
                        return startLocation$lambda$33;
                    }
                });
                return;
            }
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
        LocationPlace locationPlace = this.curLocationBean;
        if (locationPlace != null) {
            intent.putExtra("location_data", locationPlace);
        }
        intent.setFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    @Override // com.transsion.publish.adapter.a
    public void startPhoto(Context context) {
        List l11;
        String str;
        List l12;
        Intrinsics.h(context, "context");
        com.transsion.publish.adapter.g gVar = this.imageAdapter;
        if (((gVar == null || (l12 = gVar.l()) == null) ? 0 : l12.size()) < 9) {
            clickTrace("image");
            SelectImageActivity.Companion companion = SelectImageActivity.INSTANCE;
            com.transsion.publish.adapter.g gVar2 = this.imageAdapter;
            companion.a(context, 0, 9 - ((gVar2 == null || (l11 = gVar2.l()) == null) ? 0 : l11.size()), new ArrayList());
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (str = activity.getString(R$string.add_img_max_tips)) == null) {
            str = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
        String format = String.format(str, Arrays.copyOf(new Object[]{9}, 1));
        Intrinsics.g(format, "format(...)");
        com.tn.lib.widget.toast.core.h.f41533a.l(format);
    }

    @Override // com.transsion.publish.adapter.a
    public void startVideo(Context context) {
        String str;
        List l11;
        Intrinsics.h(context, "context");
        com.transsion.publish.adapter.v vVar = this.videoAdapter;
        if (((vVar == null || (l11 = vVar.l()) == null) ? 0 : l11.size()) >= 1) {
            FragmentActivity activity = getActivity();
            if (activity == null || (str = activity.getString(R$string.add_video_max_tips)) == null) {
                str = "";
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String format = String.format(str, Arrays.copyOf(new Object[]{1}, 1));
            Intrinsics.g(format, "format(...)");
            com.tn.lib.widget.toast.core.h.f41533a.l(format);
            return;
        }
        clickTrace("vidio");
        if (this.underOS33) {
            Intent intent = new Intent(context, (Class<?>) SelectVideoActivity.class);
            intent.setFlags(ASTNode.DEOP);
            startActivity(intent);
        } else {
            androidx.activity.result.b bVar = this.videoSelectLauncher;
            if (bVar != null) {
                bVar.a(androidx.activity.result.f.b(g.e.f62241a, 0, false, null, 14, null));
            }
        }
    }

    @Override // com.transsion.publish.adapter.a
    public void startWork(Context context) {
        Intrinsics.h(context, "context");
        clickTrace("choose a subject");
        yj.b bVar = (yj.b) yj.a.f79145a.a(yj.b.class);
        if (bVar != null) {
            Context requireContext = requireContext();
            Intrinsics.g(requireContext, "requireContext(...)");
            bVar.e(requireContext);
        }
    }
}
