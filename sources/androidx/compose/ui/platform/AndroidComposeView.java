package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.f;
import androidx.compose.ui.focus.FocusOwner$CC;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.focus.b;
import androidx.compose.ui.graphics.a4;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.u4;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.layout.g0;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.y0;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.ViewTreeLifecycleOwner;
import androidx.view.ViewTreeSavedStateRegistryOwner;
import c0.a;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import d0.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import y.g;

@Metadata(d1 = {"\u0000È\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0002É\u0004\b\u0000\u0018\u0000 \u0083\u00052\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0094\u0002\u0084\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0012\u001a\u00020\u000f2'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\r0\f¢\u0006\u0002\b\u0010H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010#\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J#\u0010-\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J!\u00101\u001a\u0002002\u0006\u0010,\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b1\u00102J)\u00104\u001a\u00020\u00162\u0006\u00103\u001a\u0002002\u0006\u0010,\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00162\u0006\u00106\u001a\u000200H\u0016¢\u0006\u0004\b7\u00108J\u001a\u0010=\u001a\u0002002\u0006\u0010:\u001a\u000209H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0017\u0010@\u001a\u0002002\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010<J\u0017\u0010A\u001a\u0002002\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bA\u0010<J\u0017\u0010C\u001a\u00020\u00162\u0006\u0010B\u001a\u000200H\u0016¢\u0006\u0004\bC\u00108J\u0017\u0010F\u001a\u00020\u00162\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020\u00162\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020\u00162\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bL\u0010KJ\r\u0010M\u001a\u00020\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0016H\u0016¢\u0006\u0004\bO\u0010NJ\u001d\u0010R\u001a\u00020\u00162\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00160PH\u0016¢\u0006\u0004\bR\u0010SJ\u0019\u0010U\u001a\u00020\u00162\b\u0010T\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\bU\u0010VJ!\u0010U\u001a\u00020\u00162\b\u0010T\u001a\u0004\u0018\u00010)2\u0006\u0010W\u001a\u00020+H\u0016¢\u0006\u0004\bU\u0010XJ)\u0010U\u001a\u00020\u00162\b\u0010T\u001a\u0004\u0018\u00010)2\u0006\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020+H\u0016¢\u0006\u0004\bU\u0010[J#\u0010U\u001a\u00020\u00162\b\u0010T\u001a\u0004\u0018\u00010)2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0004\bU\u0010^J+\u0010U\u001a\u00020\u00162\b\u0010T\u001a\u0004\u0018\u00010)2\u0006\u0010W\u001a\u00020+2\b\u0010]\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0004\bU\u0010_J\u001d\u0010c\u001a\u00020\u00162\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020H¢\u0006\u0004\bc\u0010dJ\u0015\u0010e\u001a\u00020\u00162\u0006\u0010a\u001a\u00020`¢\u0006\u0004\be\u0010fJ\u001d\u0010i\u001a\u00020\u00162\u0006\u0010a\u001a\u00020`2\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bi\u0010jJ\u0017\u0010l\u001a\u00020\u00162\u0006\u0010k\u001a\u000200H\u0016¢\u0006\u0004\bl\u00108J\"\u0010l\u001a\u00020\u00162\u0006\u0010b\u001a\u00020H2\u0006\u0010n\u001a\u00020mH\u0016ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ\u001f\u0010r\u001a\u00020\u00162\u0006\u0010b\u001a\u00020H2\u0006\u0010q\u001a\u000200H\u0016¢\u0006\u0004\br\u0010sJ/\u0010v\u001a\u00020\u00162\u0006\u0010b\u001a\u00020H2\u0006\u0010q\u001a\u0002002\u0006\u0010t\u001a\u0002002\u0006\u0010u\u001a\u000200H\u0016¢\u0006\u0004\bv\u0010wJ'\u0010x\u001a\u00020\u00162\u0006\u0010b\u001a\u00020H2\u0006\u0010q\u001a\u0002002\u0006\u0010t\u001a\u000200H\u0016¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020\u00162\u0006\u0010b\u001a\u00020HH\u0016¢\u0006\u0004\bz\u0010KJ\u000f\u0010{\u001a\u00020\u0016H\u0016¢\u0006\u0004\b{\u0010NJ\u001f\u0010~\u001a\u00020\u00162\u0006\u0010|\u001a\u00020+2\u0006\u0010}\u001a\u00020+H\u0014¢\u0006\u0004\b~\u0010\u007fJ?\u0010\u0085\u0001\u001a\u00020\u00162\u0007\u0010\u0080\u0001\u001a\u0002002\u0007\u0010\u0081\u0001\u001a\u00020+2\u0007\u0010\u0082\u0001\u001a\u00020+2\u0007\u0010\u0083\u0001\u001a\u00020+2\u0007\u0010\u0084\u0001\u001a\u00020+H\u0014¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001a\u0010\u0087\u0001\u001a\u00020\u00162\u0006\u0010h\u001a\u00020gH\u0014¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001Jp\u0010\u0092\u0001\u001a\u00030\u0091\u00012@\u0010\u008e\u0001\u001a;\u0012\u0016\u0012\u00140\u0089\u0001¢\u0006\u000e\b\u008a\u0001\u0012\t\b\u008b\u0001\u0012\u0004\b\b(h\u0012\u0019\u0012\u0017\u0018\u00010\u008c\u0001¢\u0006\u000f\b\u008a\u0001\u0012\n\b\u008b\u0001\u0012\u0005\b\b(\u008d\u0001\u0012\u0004\u0012\u00020\u00160\f2\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160P2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001c\u0010\u0097\u0001\u001a\u0002002\b\u0010\u0094\u0001\u001a\u00030\u0091\u0001H\u0000¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0011\u0010\u0098\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0005\b\u0098\u0001\u0010NJ\u0019\u0010\u0099\u0001\u001a\u00020\u00162\u0006\u0010b\u001a\u00020HH\u0016¢\u0006\u0005\b\u0099\u0001\u0010KJ\u001e\u0010\u009b\u0001\u001a\u00020\u00162\u000b\u0010a\u001a\u00070)j\u0003`\u009a\u0001H\u0016¢\u0006\u0005\b\u009b\u0001\u0010VJ\u001b\u0010\u009d\u0001\u001a\u00020\u00162\u0007\u0010Q\u001a\u00030\u009c\u0001H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J \u0010¢\u0001\u001a\u0005\u0018\u00010\u009f\u00012\u0006\u0010:\u001a\u000209H\u0016ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001J\u001a\u0010£\u0001\u001a\u00020\u00162\u0006\u0010h\u001a\u00020gH\u0014¢\u0006\u0006\b£\u0001\u0010\u0088\u0001J%\u0010§\u0001\u001a\u00020\u00162\b\u0010\u0094\u0001\u001a\u00030\u0091\u00012\u0007\u0010¤\u0001\u001a\u000200H\u0000¢\u0006\u0006\b¥\u0001\u0010¦\u0001J'\u0010«\u0001\u001a\u00020\u00162\u0015\u0010ª\u0001\u001a\u0010\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u00160¨\u0001¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0013\u0010\u00ad\u0001\u001a\u00020\u0016H\u0086@¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0013\u0010¯\u0001\u001a\u00020\u0016H\u0086@¢\u0006\u0006\b¯\u0001\u0010®\u0001J\u0011\u0010°\u0001\u001a\u00020\u0016H\u0016¢\u0006\u0005\b°\u0001\u0010NJ\u0011\u0010±\u0001\u001a\u00020\u0016H\u0014¢\u0006\u0005\b±\u0001\u0010NJ\u0011\u0010²\u0001\u001a\u00020\u0016H\u0014¢\u0006\u0005\b²\u0001\u0010NJ%\u0010´\u0001\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0007\u0010³\u0001\u001a\u00020+H\u0016¢\u0006\u0006\b´\u0001\u0010µ\u0001J#\u0010¹\u0001\u001a\u00020\u00162\u000f\u0010¸\u0001\u001a\n\u0012\u0005\u0012\u00030·\u00010¶\u0001H\u0016¢\u0006\u0006\b¹\u0001\u0010º\u0001J8\u0010Á\u0001\u001a\u00020\u00162\b\u0010¼\u0001\u001a\u00030»\u00012\b\u0010¾\u0001\u001a\u00030½\u00012\u0010\u0010À\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¿\u00010 H\u0017¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J%\u0010Æ\u0001\u001a\u00020\u00162\u0011\u0010Å\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ä\u00010Ã\u0001H\u0017¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u001c\u0010Ê\u0001\u001a\u0002002\b\u0010É\u0001\u001a\u00030È\u0001H\u0016¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u001c\u0010Ì\u0001\u001a\u0002002\b\u0010É\u0001\u001a\u00030È\u0001H\u0016¢\u0006\u0006\bÌ\u0001\u0010Ë\u0001J\u001a\u0010Í\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u001a\u0010Ï\u0001\u001a\u0002002\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0006\bÏ\u0001\u0010Î\u0001J \u0010Ô\u0001\u001a\u00030Ð\u00012\b\u0010Ñ\u0001\u001a\u00030Ð\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J\u001f\u0010Ô\u0001\u001a\u00020\u00162\b\u0010Ö\u0001\u001a\u00030Õ\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b×\u0001\u0010Ø\u0001J \u0010Û\u0001\u001a\u00030Ð\u00012\b\u0010Ù\u0001\u001a\u00030Ð\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bÚ\u0001\u0010Ó\u0001J\u0012\u0010Ü\u0001\u001a\u000200H\u0016¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u001f\u0010á\u0001\u001a\u0005\u0018\u00010à\u00012\b\u0010ß\u0001\u001a\u00030Þ\u0001H\u0016¢\u0006\u0006\bá\u0001\u0010â\u0001J \u0010å\u0001\u001a\u00030Ð\u00012\b\u0010ã\u0001\u001a\u00030Ð\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bä\u0001\u0010Ó\u0001J \u0010ç\u0001\u001a\u00030Ð\u00012\b\u0010Ñ\u0001\u001a\u00030Ð\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bæ\u0001\u0010Ó\u0001J\u001c\u0010ê\u0001\u001a\u00020\u00162\b\u0010é\u0001\u001a\u00030è\u0001H\u0014¢\u0006\u0006\bê\u0001\u0010ë\u0001J\u001b\u0010í\u0001\u001a\u00020\u00162\u0007\u0010ì\u0001\u001a\u00020+H\u0016¢\u0006\u0006\bí\u0001\u0010î\u0001J\u001b\u0010ï\u0001\u001a\u0002002\u0007\u0010?\u001a\u00030È\u0001H\u0016¢\u0006\u0006\bï\u0001\u0010Ë\u0001J\u001b\u0010ñ\u0001\u001a\u0004\u0018\u00010)2\u0007\u0010ð\u0001\u001a\u00020+¢\u0006\u0006\bñ\u0001\u0010ò\u0001J\u0012\u0010ó\u0001\u001a\u000200H\u0016¢\u0006\u0006\bó\u0001\u0010Ý\u0001J\u001f\u0010õ\u0001\u001a\u0002002\b\u0010ô\u0001\u001a\u00030\u009f\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010Î\u0001J\u0015\u0010÷\u0001\u001a\u0005\u0018\u00010ö\u0001H\u0002¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u001c\u0010ù\u0001\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0006\bù\u0001\u0010ò\u0001J,\u0010ú\u0001\u001a\u0002002\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u009f\u00012\t\u0010/\u001a\u0005\u0018\u00010ö\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010û\u0001J\u0011\u0010ü\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0005\bü\u0001\u0010NJE\u0010\u0083\u0002\u001a\u0002002\b\u0010þ\u0001\u001a\u00030ý\u00012\b\u0010\u0080\u0002\u001a\u00030ÿ\u00012\u001a\u0010\u0082\u0002\u001a\u0015\u0012\u0005\u0012\u00030\u0081\u0002\u0012\u0004\u0012\u00020\u00160¨\u0001¢\u0006\u0002\b\u0010H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002J\u001b\u0010\u0086\u0002\u001a\u00020\u00162\u0007\u0010\u0085\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0006\b\u0086\u0002\u0010\u0087\u0002J/\u0010\u008d\u0002\u001a\u00020\u00162\u0007\u0010\u0088\u0002\u001a\u00020+2\b\u0010\u008a\u0002\u001a\u00030\u0089\u00022\b\u0010\u008c\u0002\u001a\u00030\u008b\u0002H\u0002¢\u0006\u0006\b\u008d\u0002\u0010\u008e\u0002J\u001e\u0010\u0090\u0002\u001a\u00020\u00162\u000b\b\u0002\u0010\u008f\u0002\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0005\b\u0090\u0002\u0010KJ\u0016\u0010\u0091\u0002\u001a\u000200*\u00020HH\u0002¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u0011\u0010\u0093\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b\u0093\u0002\u0010NJ+\u0010\u0096\u0002\u001a\u00030\u0095\u00022\u0007\u0010\u0094\u0002\u001a\u00020+2\u0007\u0010\u0084\u0001\u001a\u00020+H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0096\u0002\u0010\u0097\u0002J\"\u0010\u0099\u0002\u001a\u00030\u0095\u00022\u0007\u0010\u0098\u0002\u001a\u00020+H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0099\u0002\u0010\u009a\u0002J\u0011\u0010\u009b\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b\u009b\u0002\u0010NJ\u0019\u0010\u009c\u0002\u001a\u00020\u00162\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0005\b\u009c\u0002\u0010KJ\u0019\u0010\u0083\u0001\u001a\u00020\u00162\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0005\b\u0083\u0001\u0010KJ\u001b\u0010\u009d\u0002\u001a\u0002002\u0007\u0010?\u001a\u00030È\u0001H\u0002¢\u0006\u0006\b\u009d\u0002\u0010Ë\u0001J#\u0010\u009f\u0002\u001a\u00030\u009e\u00022\b\u0010É\u0001\u001a\u00030È\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009f\u0002\u0010 \u0002J%\u0010¢\u0002\u001a\u0002002\u0007\u0010?\u001a\u00030È\u00012\b\u0010¡\u0002\u001a\u00030È\u0001H\u0002¢\u0006\u0006\b¢\u0002\u0010£\u0002J\u001b\u0010¤\u0002\u001a\u0002002\u0007\u0010?\u001a\u00030È\u0001H\u0002¢\u0006\u0006\b¤\u0002\u0010Ë\u0001J#\u0010¥\u0002\u001a\u00030\u009e\u00022\b\u0010É\u0001\u001a\u00030È\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¥\u0002\u0010 \u0002J9\u0010©\u0002\u001a\u00020\u00162\b\u0010É\u0001\u001a\u00030È\u00012\u0007\u0010¦\u0002\u001a\u00020+2\u0007\u0010§\u0002\u001a\u00020D2\t\b\u0002\u0010¨\u0002\u001a\u000200H\u0002¢\u0006\u0006\b©\u0002\u0010ª\u0002J\u001c\u0010«\u0002\u001a\u0002002\b\u0010É\u0001\u001a\u00030È\u0001H\u0002¢\u0006\u0006\b«\u0002\u0010Ë\u0001J\u0011\u0010¬\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b¬\u0002\u0010NJ\u001c\u0010\u00ad\u0002\u001a\u00020\u00162\b\u0010É\u0001\u001a\u00030È\u0001H\u0002¢\u0006\u0006\b\u00ad\u0002\u0010®\u0002J\u0011\u0010¯\u0002\u001a\u00020\u0016H\u0002¢\u0006\u0005\b¯\u0002\u0010NJ\u0012\u0010°\u0002\u001a\u000200H\u0002¢\u0006\u0006\b°\u0002\u0010Ý\u0001J\u001b\u0010\u0082\u0001\u001a\u0002002\u0007\u0010?\u001a\u00030È\u0001H\u0002¢\u0006\u0006\b\u0082\u0001\u0010Ë\u0001J\u001b\u0010±\u0002\u001a\u0002002\u0007\u0010?\u001a\u00030È\u0001H\u0002¢\u0006\u0006\b±\u0002\u0010Ë\u0001J&\u0010\u0081\u0001\u001a\u0004\u0018\u00010)2\u0007\u0010ð\u0001\u001a\u00020+2\u0007\u0010²\u0002\u001a\u00020)H\u0002¢\u0006\u0006\b\u0081\u0001\u0010³\u0002R \u0010´\u0002\u001a\u00030Ð\u00018\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b\u0094\u0002\u0010¥\u0002R\u0019\u0010¶\u0002\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010µ\u0002R \u0010¼\u0002\u001a\u00030·\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¸\u0002\u0010¹\u0002\u001a\u0006\bº\u0002\u0010»\u0002R5\u0010Å\u0002\u001a\u00030½\u00022\b\u0010¾\u0002\u001a\u00030½\u00028V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b¿\u0002\u0010À\u0002\u001a\u0006\bÁ\u0002\u0010Â\u0002\"\u0006\bÃ\u0002\u0010Ä\u0002R\u0018\u0010È\u0002\u001a\u00030Æ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0002\u0010Ç\u0002R\u0018\u0010Ë\u0002\u001a\u00030É\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0002\u0010Ê\u0002R \u0010Ð\u0002\u001a\u00030Ì\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0091\u0002\u0010Í\u0002\u001a\u0006\bÎ\u0002\u0010Ï\u0002R\u0018\u0010Ó\u0002\u001a\u00030Ñ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0002\u0010Ò\u0002R1\u0010\t\u001a\u00020\b2\u0007\u0010Ô\u0002\u001a\u00020\b8\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\b\u0099\u0002\u0010Õ\u0002\u001a\u0006\bÖ\u0002\u0010×\u0002\"\u0006\bØ\u0002\u0010Ù\u0002R \u0010Þ\u0002\u001a\u00030Ú\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0093\u0002\u0010Û\u0002\u001a\u0006\bÜ\u0002\u0010Ý\u0002R\u0018\u0010á\u0002\u001a\u00030ß\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bù\u0001\u0010à\u0002R\u0018\u0010ä\u0002\u001a\u00030â\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010ã\u0002R\u0018\u0010æ\u0002\u001a\u00030â\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0002\u0010ã\u0002R\u0018\u0010ê\u0002\u001a\u00030ç\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0002\u0010é\u0002R\u001f\u0010î\u0002\u001a\u00020H8\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u009f\u0002\u0010ë\u0002\u001a\u0006\bì\u0002\u0010í\u0002R \u0010ó\u0002\u001a\u00030ï\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u009d\u0002\u0010ð\u0002\u001a\u0006\bñ\u0002\u0010ò\u0002R \u0010ø\u0002\u001a\u00030ô\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¢\u0002\u0010õ\u0002\u001a\u0006\bö\u0002\u0010÷\u0002R\u0018\u0010û\u0002\u001a\u00030ù\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010ú\u0002R*\u0010\u0082\u0003\u001a\u00030ü\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009c\u0002\u0010ý\u0002\u001a\u0006\bþ\u0002\u0010ÿ\u0002\"\u0006\b\u0080\u0003\u0010\u0081\u0003R \u0010\u0087\u0003\u001a\u00030\u0083\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0084\u0003\u001a\u0006\b\u0085\u0003\u0010\u0086\u0003R \u0010\u008c\u0003\u001a\u00030\u0088\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¤\u0002\u0010\u0089\u0003\u001a\u0006\b\u008a\u0003\u0010\u008b\u0003R \u0010\u0091\u0003\u001a\u00030\u008d\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b«\u0002\u0010\u008e\u0003\u001a\u0006\b\u008f\u0003\u0010\u0090\u0003R\u001f\u0010\u0094\u0003\u001a\n\u0012\u0005\u0012\u00030\u0091\u00010\u0092\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0002\u0010\u0093\u0003R#\u0010\u0095\u0003\u001a\f\u0012\u0005\u0012\u00030\u0091\u0001\u0018\u00010\u0092\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010\u0093\u0003R\u0019\u0010\u0096\u0003\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010µ\u0002R\u0019\u0010\u0097\u0003\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010µ\u0002R\u0018\u0010\u009a\u0003\u001a\u00030\u0098\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bú\u0001\u0010\u0099\u0003R\u0018\u0010\u009d\u0003\u001a\u00030\u009b\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u009c\u0003R7\u0010¢\u0003\u001a\u0010\u0012\u0005\u0012\u00030è\u0001\u0012\u0004\u0012\u00020\u00160¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0002\u0010\u009e\u0003\u001a\u0006\b\u009f\u0003\u0010 \u0003\"\u0006\b¡\u0003\u0010¬\u0001R\u001a\u0010¥\u0003\u001a\u0005\u0018\u00010£\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0002\u0010¤\u0003R\u0019\u0010¦\u0003\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0002\u0010µ\u0002R \u0010«\u0003\u001a\u00030§\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0090\u0002\u0010¨\u0003\u001a\u0006\b©\u0003\u0010ª\u0003R \u0010±\u0003\u001a\u00030¬\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u00ad\u0003\u0010®\u0003\u001a\u0006\b¯\u0003\u0010°\u0003R/\u0010¶\u0003\u001a\u0002008\u0016@\u0016X\u0096\u000e¢\u0006\u001e\n\u0006\b²\u0003\u0010µ\u0002\u0012\u0005\bµ\u0003\u0010N\u001a\u0006\b³\u0003\u0010Ý\u0001\"\u0005\b´\u0003\u00108R\u001c\u0010º\u0003\u001a\u0005\u0018\u00010·\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0003\u0010¹\u0003R\u001c\u0010½\u0003\u001a\u0005\u0018\u00010»\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0002\u0010¼\u0003R!\u0010¿\u0003\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b©\u0002\u0010¾\u0003R\u0019\u0010Á\u0003\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0003\u0010µ\u0002R\u0018\u0010Ä\u0003\u001a\u00030Â\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010Ã\u0003R \u0010Ê\u0003\u001a\u00030Å\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÆ\u0003\u0010Ç\u0003\u001a\u0006\bÈ\u0003\u0010É\u0003R \u0010Ì\u0003\u001a\u00030Ë\u00038\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b\u009b\u0002\u0010¥\u0002R\u0018\u0010Ï\u0003\u001a\u00030½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0003\u0010Î\u0003R\u001e\u0010Ò\u0003\u001a\u00030Õ\u00018\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÐ\u0003\u0010Ñ\u0003R\u001e\u0010Ô\u0003\u001a\u00030Õ\u00018\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÓ\u0003\u0010Ñ\u0003R\u001e\u0010Ö\u0003\u001a\u00030Õ\u00018\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÕ\u0003\u0010Ñ\u0003R/\u0010Ü\u0003\u001a\u00020D8\u0000@\u0000X\u0081\u000e¢\u0006\u001e\n\u0006\b×\u0003\u0010¥\u0002\u0012\u0005\bÛ\u0003\u0010N\u001a\u0006\bØ\u0003\u0010Ù\u0003\"\u0005\bÚ\u0003\u0010GR\u0019\u0010Þ\u0003\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0003\u0010µ\u0002R \u0010à\u0003\u001a\u00030Ð\u00018\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bß\u0003\u0010¥\u0002R\u0019\u0010â\u0003\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0003\u0010µ\u0002R9\u0010è\u0003\u001a\u0005\u0018\u00010©\u00012\n\u0010¾\u0002\u001a\u0005\u0018\u00010©\u00018B@BX\u0082\u008e\u0002¢\u0006\u0018\n\u0006\bã\u0003\u0010À\u0002\u001a\u0006\bä\u0003\u0010å\u0003\"\u0006\bæ\u0003\u0010ç\u0003R#\u0010ì\u0003\u001a\u0005\u0018\u00010©\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bé\u0003\u0010ê\u0003\u001a\u0006\bë\u0003\u0010å\u0003R)\u0010î\u0003\u001a\u0012\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u0016\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0003\u0010\u009e\u0003R\u0018\u0010ò\u0003\u001a\u00030ï\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bð\u0003\u0010ñ\u0003R\u0018\u0010ö\u0003\u001a\u00030ó\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bô\u0003\u0010õ\u0003R\u0018\u0010ú\u0003\u001a\u00030÷\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bø\u0003\u0010ù\u0003R\u0018\u0010þ\u0003\u001a\u00030û\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bü\u0003\u0010ý\u0003R \u0010\u0084\u0004\u001a\u00030ÿ\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0080\u0004\u0010\u0081\u0004\u001a\u0006\b\u0082\u0004\u0010\u0083\u0004R%\u0010\u0089\u0004\u001a\n\u0012\u0005\u0012\u00030\u0086\u00040\u0085\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b\u0087\u0004\u0010\u0088\u0004R \u0010\u008f\u0004\u001a\u00030\u008a\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008b\u0004\u0010\u008c\u0004\u001a\u0006\b\u008d\u0004\u0010\u008e\u0004R'\u0010\u0096\u0004\u001a\u00030\u0090\u00048\u0016X\u0097\u0004¢\u0006\u0017\n\u0006\b\u0091\u0004\u0010\u0092\u0004\u0012\u0005\b\u0095\u0004\u0010N\u001a\u0006\b\u0093\u0004\u0010\u0094\u0004R5\u0010\u009d\u0004\u001a\u00030\u0097\u00042\b\u0010¾\u0002\u001a\u00030\u0097\u00048V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b\u0098\u0004\u0010À\u0002\u001a\u0006\b\u0099\u0004\u0010\u009a\u0004\"\u0006\b\u009b\u0004\u0010\u009c\u0004R\u0019\u0010\u009f\u0004\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0004\u0010¸\u0003R5\u0010ì\u0001\u001a\u00030 \u00042\b\u0010¾\u0002\u001a\u00030 \u00048V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b¡\u0004\u0010À\u0002\u001a\u0006\b¢\u0004\u0010£\u0004\"\u0006\b¤\u0004\u0010¥\u0004R \u0010«\u0004\u001a\u00030¦\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b§\u0004\u0010¨\u0004\u001a\u0006\b©\u0004\u0010ª\u0004R\u0018\u0010¯\u0004\u001a\u00030¬\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0004\u0010®\u0004R \u0010µ\u0004\u001a\u00030°\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b±\u0004\u0010²\u0004\u001a\u0006\b³\u0004\u0010´\u0004R \u0010»\u0004\u001a\u00030¶\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b·\u0004\u0010¸\u0004\u001a\u0006\b¹\u0004\u0010º\u0004R\u001c\u0010¾\u0004\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0004\u0010½\u0004R\u0019\u0010À\u0004\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0004\u0010¥\u0002R\u001f\u0010Ä\u0004\u001a\n\u0012\u0005\u0012\u00030\u0091\u00010Á\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0004\u0010Ã\u0004R&\u0010È\u0004\u001a\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010P0Å\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0004\u0010Ç\u0004R\u0018\u0010Ì\u0004\u001a\u00030É\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0004\u0010Ë\u0004R\u0018\u0010Ð\u0004\u001a\u00030Í\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0004\u0010Ï\u0004R\u0019\u0010Ò\u0004\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0004\u0010µ\u0002R\u001d\u0010Õ\u0004\u001a\b\u0012\u0004\u0012\u00020\u00160P8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0004\u0010Ô\u0004R\u0018\u0010Ù\u0004\u001a\u00030Ö\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0004\u0010Ø\u0004R\u0019\u0010Û\u0004\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0004\u0010µ\u0002R\u001a\u0010ß\u0004\u001a\u0005\u0018\u00010Ü\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0004\u0010Þ\u0004R \u0010å\u0004\u001a\u00030à\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bá\u0004\u0010â\u0004\u001a\u0006\bã\u0004\u0010ä\u0004R\u0016\u0010a\u001a\u00020)8VX\u0096\u0004¢\u0006\b\u001a\u0006\bæ\u0004\u0010ç\u0004R\u0018\u0010ë\u0004\u001a\u00030è\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bé\u0004\u0010ê\u0004R\u001a\u0010¹\u0001\u001a\u0005\u0018\u00010ì\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bí\u0004\u0010î\u0004R\u0018\u0010ñ\u0004\u001a\u00030·\u00038@X\u0080\u0004¢\u0006\b\u001a\u0006\bï\u0004\u0010ð\u0004R\u0017\u0010ó\u0004\u001a\u00020D8VX\u0096\u0004¢\u0006\b\u001a\u0006\bò\u0004\u0010Ù\u0003R\u0017\u0010õ\u0004\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\bô\u0004\u0010Ý\u0001R\u0018\u0010ù\u0004\u001a\u00030ö\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\b÷\u0004\u0010ø\u0004R\u0018\u0010ý\u0004\u001a\u00030ú\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bû\u0004\u0010ü\u0004R\u0017\u0010ÿ\u0004\u001a\u0002008@X\u0080\u0004¢\u0006\b\u001a\u0006\bþ\u0004\u0010Ý\u0001R\u0017\u0010\u0080\u0005\u001a\u0002008VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0080\u0005\u0010Ý\u0001R\u001c\u0010\u0082\u0005\u001a\u00020+*\u00030è\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bå\u0002\u0010\u0081\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0084\u0005"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/y0;", "Landroidx/compose/ui/platform/t2;", "Landroidx/compose/ui/input/pointer/i0;", "Landroidx/lifecycle/f;", "Landroid/content/Context;", "context", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "session", "textInputSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Rect;", "rect", "", "getFocusedRect", "(Landroid/graphics/Rect;)V", "Landroid/view/ViewStructure;", "structure", "dispatchProvideStructure", "(Landroid/view/ViewStructure;)V", "localVisibleRect", "Landroid/graphics/Point;", "windowOffset", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "targets", "onScrollCaptureSearch", "(Landroid/graphics/Rect;Landroid/graphics/Point;Ljava/util/function/Consumer;)V", "Landroidx/lifecycle/u;", "owner", "onResume", "(Landroidx/lifecycle/u;)V", "Landroid/view/View;", "focused", "", "direction", "focusSearch", "(Landroid/view/View;I)Landroid/view/View;", "previouslyFocusedRect", "", "requestFocus", "(ILandroid/graphics/Rect;)Z", "gainFocus", "onFocusChanged", "(ZILandroid/graphics/Rect;)V", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "Ld0/b;", "keyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendKeyEvent", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "dispatchKeyEvent", "dispatchKeyEventPreIme", OfflineConstantsKt.OFFLINE_CONFIG_ENABLE, "forceAccessibilityForTesting", "", "intervalMillis", "setAccessibilityEventBatchIntervalMillis", "(J)V", "Landroidx/compose/ui/node/LayoutNode;", "node", "onAttach", "(Landroidx/compose/ui/node/LayoutNode;)V", "onDetach", "requestClearInvalidObservations", "()V", "onEndApplyChanges", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOnEndApplyChangesListener", "(Lkotlin/jvm/functions/Function0;)V", "child", "addView", "(Landroid/view/View;)V", "index", "(Landroid/view/View;I)V", "width", "height", "(Landroid/view/View;II)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "layoutNode", "addAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;Landroidx/compose/ui/node/LayoutNode;)V", "removeAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "Landroid/graphics/Canvas;", "canvas", "drawAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;Landroid/graphics/Canvas;)V", "sendPointerUpdate", "measureAndLayout", "Lo0/b;", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "affectsLookahead", "forceMeasureTheSubtree", "(Landroidx/compose/ui/node/LayoutNode;Z)V", "forceRequest", "scheduleMeasureAndLayout", "onRequestMeasure", "(Landroidx/compose/ui/node/LayoutNode;ZZZ)V", "onRequestRelayout", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "requestOnPositionedCallback", "measureAndLayoutForTest", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", CampaignEx.JSON_KEY_AD_R, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "onLayout", "(ZIIII)V", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroidx/compose/ui/graphics/m1;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "drawBlock", "invalidateParentLayer", "explicitLayer", "Landroidx/compose/ui/node/w0;", "createLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)Landroidx/compose/ui/node/w0;", "layer", "recycle$ui_release", "(Landroidx/compose/ui/node/w0;)Z", "recycle", "onSemanticsChange", "onLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "onInteropViewLayoutChange", "Landroidx/compose/ui/node/y0$b;", "registerOnLayoutCompletedListener", "(Landroidx/compose/ui/node/y0$b;)V", "Landroidx/compose/ui/focus/b;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/b;", "getFocusDirection", "dispatchDraw", "isDirty", "notifyLayerIsDirty$ui_release", "(Landroidx/compose/ui/node/w0;Z)V", "notifyLayerIsDirty", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/AndroidComposeView$b;", "callback", "setOnViewTreeOwnersAvailable", "(Lkotlin/jvm/functions/Function1;)V", "boundsUpdatesContentCaptureEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesAccessibilityEventLoop", "invalidateDescendants", "onAttachedToWindow", "onDetachedFromWindow", "flags", "onProvideAutofillVirtualStructure", "(Landroid/view/ViewStructure;I)V", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "values", "autofill", "(Landroid/util/SparseArray;)V", "", "virtualIds", "", "supportedFormats", "Landroid/view/translation/ViewTranslationRequest;", "requestsCollector", "onCreateVirtualViewTranslationRequests", "([J[ILjava/util/function/Consumer;)V", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "response", "onVirtualViewTranslationResponses", "(Landroid/util/LongSparseArray;)V", "Landroid/view/MotionEvent;", "motionEvent", "dispatchGenericMotionEvent", "(Landroid/view/MotionEvent;)Z", "dispatchTouchEvent", "canScrollHorizontally", "(I)Z", "canScrollVertically", "Ly/g;", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "localToScreen", "Landroidx/compose/ui/graphics/i4;", "localTransform", "localToScreen-58bKbWc", "([F)V", "positionOnScreen", "screenToLocal-MK-Hz9U", "screenToLocal", "onCheckIsTextEditor", "()Z", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "calculateLocalPosition", "calculatePositionInWindow-MK-Hz9U", "calculatePositionInWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "layoutDirection", "onRtlPropertiesChanged", "(I)V", "dispatchHoverEvent", "accessibilityId", "findViewByAccessibilityIdTraversal", "(I)Landroid/view/View;", "shouldDelayChildPressedState", "focusDirection", "z", "Ly/i;", "y", "()Ly/i;", CampaignEx.JSON_KEY_AD_K, "A", "(Landroidx/compose/ui/focus/b;Ly/i;)Z", "x", "Landroidx/compose/ui/draganddrop/g;", "transferData", "Ly/m;", "decorationSize", "Lz/g;", "drawDragDecoration", "M", "(Landroidx/compose/ui/draganddrop/g;JLkotlin/jvm/functions/Function1;)Z", "viewGroup", "h", "(Landroid/view/ViewGroup;)V", "virtualViewId", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "extraDataKey", "e", "(ILandroid/view/accessibility/AccessibilityNodeInfo;Ljava/lang/String;)V", "nodeToRemeasure", "F", be.g.f16474b, "(Landroidx/compose/ui/node/LayoutNode;)Z", com.mbridge.msdk.foundation.same.report.j.f35620b, "a", "Lkotlin/ULong;", "B", "(II)J", "measureSpec", "i", "(I)J", "O", "s", TtmlNode.TAG_P, "Landroidx/compose/ui/input/pointer/j0;", "o", "(Landroid/view/MotionEvent;)I", "lastEvent", CampaignEx.JSON_KEY_AD_Q, "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z", TmcStartParams.KEY_URL_SHORT, "J", EventConstants.KEY_ACTION, "eventTime", "forceHover", "K", "(Landroid/view/MotionEvent;IJZ)V", "v", "C", "D", "(Landroid/view/MotionEvent;)V", "E", "f", "w", "currentView", "(ILandroid/view/View;)Landroid/view/View;", "lastDownPointerPosition", "Z", "superclassInitComplete", "Landroidx/compose/ui/node/d0;", "c", "Landroidx/compose/ui/node/d0;", "getSharedDrawScope", "()Landroidx/compose/ui/node/d0;", "sharedDrawScope", "Lo0/e;", "<set-?>", "d", "Landroidx/compose/runtime/i1;", "getDensity", "()Lo0/e;", "setDensity", "(Lo0/e;)V", "density", "Landroidx/compose/ui/semantics/d;", "Landroidx/compose/ui/semantics/d;", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsModifier", "Landroidx/compose/ui/focus/i;", "Landroidx/compose/ui/focus/i;", "getFocusOwner", "()Landroidx/compose/ui/focus/i;", "focusOwner", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "dragAndDropModifierOnDragListener", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/compose/ui/draganddrop/c;", "Landroidx/compose/ui/draganddrop/c;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/c;", "dragAndDropManager", "Landroidx/compose/ui/platform/w2;", "Landroidx/compose/ui/platform/w2;", "_windowInfo", "Landroidx/compose/ui/f;", "Landroidx/compose/ui/f;", "keyInputModifier", "m", "rotaryInputModifier", "Landroidx/compose/ui/graphics/n1;", "n", "Landroidx/compose/ui/graphics/n1;", "canvasHolder", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "root", "Landroidx/compose/ui/node/g1;", "Landroidx/compose/ui/node/g1;", "getRootForTest", "()Landroidx/compose/ui/node/g1;", "rootForTest", "Landroidx/compose/ui/semantics/m;", "Landroidx/compose/ui/semantics/m;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/m;", "semanticsOwner", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "composeAccessibilityDelegate", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "contentCaptureManager", "Landroidx/compose/ui/platform/i;", "Landroidx/compose/ui/platform/i;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/i;", "accessibilityManager", "Landroidx/compose/ui/graphics/a4;", "Landroidx/compose/ui/graphics/a4;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/a4;", "graphicsContext", "Lx/w;", "Lx/w;", "getAutofillTree", "()Lx/w;", "autofillTree", "", "Ljava/util/List;", "dirtyLayers", "postponedDirtyLayers", "isDrawingContent", "isPendingInteropViewLayoutChangeDispatch", "Landroidx/compose/ui/input/pointer/h;", "Landroidx/compose/ui/input/pointer/h;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/a0;", "Landroidx/compose/ui/input/pointer/a0;", "pointerInputEventProcessor", "Lkotlin/jvm/functions/Function1;", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "configurationChangeObserver", "Lx/d;", "Lx/d;", "_autofill", "observationClearRequested", "Landroidx/compose/ui/platform/j;", "Landroidx/compose/ui/platform/j;", "getClipboardManager", "()Landroidx/compose/ui/platform/j;", "clipboardManager", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "G", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "H", "getShowLayoutBounds", "setShowLayoutBounds", "getShowLayoutBounds$annotations", "showLayoutBounds", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "I", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_androidViewsHandler", "Landroidx/compose/ui/platform/DrawChildContainer;", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewLayersContainer", "Lo0/b;", "onMeasureConstraints", "L", "wasMeasuredWithMultipleConstraints", "Landroidx/compose/ui/node/k0;", "Landroidx/compose/ui/node/k0;", "measureAndLayoutDelegate", "Landroidx/compose/ui/platform/o2;", "N", "Landroidx/compose/ui/platform/o2;", "getViewConfiguration", "()Landroidx/compose/ui/platform/o2;", "viewConfiguration", "Lo0/p;", "globalPosition", "P", "[I", "tmpPositionArray", "Q", "[F", "tmpMatrix", "R", "viewToWindowMatrix", "S", "windowToViewMatrix", "T", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "lastMatrixRecalculationAnimationTime", "U", "forceUseMatrixCache", "V", "windowPosition", "W", "isRenderNodeCompatible", "a0", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$b;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$b;)V", "_viewTreeOwners", "b0", "Landroidx/compose/runtime/a3;", "getViewTreeOwners", "viewTreeOwners", "c0", "onViewTreeOwnersAvailable", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "d0", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "e0", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "f0", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "touchModeChangeListener", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "g0", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/e0;", "h0", "Landroidx/compose/ui/text/input/e0;", "getTextInputService", "()Landroidx/compose/ui/text/input/e0;", "textInputService", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/i0;", "i0", "Ljava/util/concurrent/atomic/AtomicReference;", "textInputSessionMutex", "Landroidx/compose/ui/platform/g2;", "j0", "Landroidx/compose/ui/platform/g2;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/g2;", "softwareKeyboardController", "Landroidx/compose/ui/text/font/g;", "k0", "Landroidx/compose/ui/text/font/g;", "getFontLoader", "()Landroidx/compose/ui/text/font/g;", "getFontLoader$annotations", "fontLoader", "Landroidx/compose/ui/text/font/h$b;", "l0", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/h$b;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/h$b;)V", "fontFamilyResolver", "m0", "currentFontWeightAdjustment", "Landroidx/compose/ui/unit/LayoutDirection;", "n0", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Lb0/a;", "o0", "Lb0/a;", "getHapticFeedBack", "()Lb0/a;", "hapticFeedBack", "Lc0/c;", "p0", "Lc0/c;", "_inputModeManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "q0", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "modifierLocalManager", "Landroidx/compose/ui/platform/h2;", "r0", "Landroidx/compose/ui/platform/h2;", "getTextToolbar", "()Landroidx/compose/ui/platform/h2;", "textToolbar", "s0", "Landroid/view/MotionEvent;", "previousMotionEvent", "t0", "relayoutTime", "Landroidx/compose/ui/platform/u2;", "u0", "Landroidx/compose/ui/platform/u2;", "layerCache", "Landroidx/compose/runtime/collection/b;", "v0", "Landroidx/compose/runtime/collection/b;", "endApplyChangesListeners", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "w0", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "resendMotionEventRunnable", "Ljava/lang/Runnable;", "x0", "Ljava/lang/Runnable;", "sendHoverExitEvent", "y0", "hoverExitReceived", "z0", "Lkotlin/jvm/functions/Function0;", "resendMotionEventOnLayout", "Landroidx/compose/ui/platform/m0;", "A0", "Landroidx/compose/ui/platform/m0;", "matrixToWindow", "B0", "keyboardModifiersRequireUpdate", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "C0", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCapture", "Landroidx/compose/ui/input/pointer/t;", "D0", "Landroidx/compose/ui/input/pointer/t;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/t;", "pointerIconService", "getView", "()Landroid/view/View;", "Landroidx/compose/ui/platform/v2;", "getWindowInfo", "()Landroidx/compose/ui/platform/v2;", "windowInfo", "Lx/g;", "getAutofill", "()Lx/g;", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "androidViewsHandler", "getMeasureIteration", "measureIteration", "getHasPendingMeasureOrLayout", "hasPendingMeasureOrLayout", "Landroidx/compose/ui/layout/g0$a;", "getPlacementScope", "()Landroidx/compose/ui/layout/g0$a;", "placementScope", "Lc0/b;", "getInputModeManager", "()Lc0/b;", "inputModeManager", "getScrollCaptureInProgress$ui_release", "scrollCaptureInProgress", "isLifecycleInResumedState", "(Landroid/content/res/Configuration;)I", "fontWeightAdjustmentCompat", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements androidx.compose.ui.node.y0, t2, androidx.compose.ui.input.pointer.i0, androidx.view.f {
    private static Class E0;
    private static Method F0;

    /* renamed from: A, reason: from kotlin metadata */
    private final androidx.compose.ui.input.pointer.h motionEventAdapter;

    /* renamed from: A0, reason: from kotlin metadata */
    private final m0 matrixToWindow;

    /* renamed from: B, reason: from kotlin metadata */
    private final androidx.compose.ui.input.pointer.a0 pointerInputEventProcessor;

    /* renamed from: B0, reason: from kotlin metadata */
    private boolean keyboardModifiersRequireUpdate;

    /* renamed from: C, reason: from kotlin metadata */
    private Function1 configurationChangeObserver;

    /* renamed from: C0, reason: from kotlin metadata */
    private final ScrollCapture scrollCapture;

    /* renamed from: D, reason: from kotlin metadata */
    private final x.d _autofill;

    /* renamed from: D0, reason: from kotlin metadata */
    private final androidx.compose.ui.input.pointer.t pointerIconService;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean observationClearRequested;

    /* renamed from: F, reason: from kotlin metadata */
    private final j clipboardManager;

    /* renamed from: G, reason: from kotlin metadata */
    private final OwnerSnapshotObserver snapshotObserver;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean showLayoutBounds;

    /* renamed from: I, reason: from kotlin metadata */
    private AndroidViewsHandler _androidViewsHandler;

    /* renamed from: J, reason: from kotlin metadata */
    private DrawChildContainer viewLayersContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private o0.b onMeasureConstraints;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean wasMeasuredWithMultipleConstraints;

    /* renamed from: M, reason: from kotlin metadata */
    private final androidx.compose.ui.node.k0 measureAndLayoutDelegate;

    /* renamed from: N, reason: from kotlin metadata */
    private final o2 viewConfiguration;

    /* renamed from: O, reason: from kotlin metadata */
    private long globalPosition;

    /* renamed from: P, reason: from kotlin metadata */
    private final int[] tmpPositionArray;

    /* renamed from: Q, reason: from kotlin metadata */
    private final float[] tmpMatrix;

    /* renamed from: R, reason: from kotlin metadata */
    private final float[] viewToWindowMatrix;

    /* renamed from: S, reason: from kotlin metadata */
    private final float[] windowToViewMatrix;

    /* renamed from: T, reason: from kotlin metadata */
    private long lastMatrixRecalculationAnimationTime;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean forceUseMatrixCache;

    /* renamed from: V, reason: from kotlin metadata */
    private long windowPosition;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isRenderNodeCompatible;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long lastDownPointerPosition;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.runtime.i1 _viewTreeOwners;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean superclassInitComplete;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.runtime.a3 viewTreeOwners;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.node.d0 sharedDrawScope;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private Function1 onViewTreeOwnersAvailable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.runtime.i1 density;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.semantics.d rootSemanticsNode;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final EmptySemanticsElement semanticsModifier;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.focus.i focusOwner;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.text.input.e0 textInputService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CoroutineContext coroutineContext;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final AtomicReference textInputSessionMutex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.draganddrop.c dragAndDropManager;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final g2 softwareKeyboardController;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final w2 _windowInfo;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.text.font.g fontLoader;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.f keyInputModifier;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.runtime.i1 fontFamilyResolver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.f rotaryInputModifier;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private int currentFontWeightAdjustment;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.graphics.n1 canvasHolder;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.runtime.i1 layoutDirection;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final LayoutNode root;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final b0.a hapticFeedBack;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.node.g1 rootForTest;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final c0.c _inputModeManager;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.ui.semantics.m semanticsOwner;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private final ModifierLocalManager modifierLocalManager;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private final h2 textToolbar;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private AndroidContentCaptureManager contentCaptureManager;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private MotionEvent previousMotionEvent;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final i accessibilityManager;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private long relayoutTime;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final a4 graphicsContext;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final u2 layerCache;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final x.w autofillTree;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private final androidx.compose.runtime.collection.b endApplyChangesListeners;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final List dirtyLayers;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private List postponedDirtyLayers;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private final Runnable sendHoverExitEvent;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean isDrawingContent;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private boolean hoverExitReceived;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private boolean isPendingInteropViewLayoutChangeDispatch;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private final Function0 resendMotionEventOnLayout;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: androidx.compose.ui.platform.AndroidComposeView$a, reason: from kotlin metadata */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            try {
                if (AndroidComposeView.E0 == null) {
                    AndroidComposeView.E0 = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.E0;
                    AndroidComposeView.F0 = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.F0;
                Object invoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = invoke instanceof Boolean ? (Boolean) invoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.view.u f5602a;

        /* renamed from: b, reason: collision with root package name */
        private final InterfaceC1015e f5603b;

        public b(androidx.view.u uVar, InterfaceC1015e interfaceC1015e) {
            this.f5602a = uVar;
            this.f5603b = interfaceC1015e;
        }

        public final androidx.view.u a() {
            return this.f5602a;
        }

        public final InterfaceC1015e b() {
            return this.f5603b;
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements androidx.compose.ui.input.pointer.t {

        /* renamed from: a, reason: collision with root package name */
        private androidx.compose.ui.input.pointer.s f5604a = androidx.compose.ui.input.pointer.s.f5106a.a();

        c() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        androidx.compose.runtime.i1 c11;
        androidx.compose.runtime.i1 c12;
        g.a aVar = y.g.f78593b;
        this.lastDownPointerPosition = aVar.b();
        this.superclassInitComplete = true;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.sharedDrawScope = new androidx.compose.ui.node.d0(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.density = androidx.compose.runtime.r2.e(o0.a.a(context), androidx.compose.runtime.r2.h());
        androidx.compose.ui.semantics.d dVar = new androidx.compose.ui.semantics.d();
        this.rootSemanticsNode = dVar;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(dVar);
        this.semanticsModifier = emptySemanticsElement;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.jvm.internal.MutablePropertyReference0
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.jvm.internal.MutablePropertyReference0
            public void set(Object obj) {
                ((AndroidComposeView) this.receiver).setLayoutDirection((LayoutDirection) obj);
            }
        });
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener;
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = dragAndDropModifierOnDragListener;
        this._windowInfo = new w2();
        f.a aVar2 = androidx.compose.ui.f.f4253a;
        androidx.compose.ui.f a11 = androidx.compose.ui.input.key.a.a(aVar2, new Function1<d0.b, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m155invokeZmokQxo(((d0.b) obj).f());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m155invokeZmokQxo(KeyEvent keyEvent) {
                y.i y10;
                View k11;
                final androidx.compose.ui.focus.b m148getFocusDirectionP8AzH3I = AndroidComposeView.this.m148getFocusDirectionP8AzH3I(keyEvent);
                if (m148getFocusDirectionP8AzH3I == null || !d0.c.e(d0.d.b(keyEvent), d0.c.f61245a.a())) {
                    return Boolean.FALSE;
                }
                y10 = AndroidComposeView.this.y();
                Boolean e11 = AndroidComposeView.this.getFocusOwner().e(m148getFocusDirectionP8AzH3I.o(), y10, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        Boolean k12 = FocusTransactionsKt.k(focusTargetNode, androidx.compose.ui.focus.b.this.o());
                        return Boolean.valueOf(k12 != null ? k12.booleanValue() : true);
                    }
                });
                if (e11 != null ? e11.booleanValue() : true) {
                    return Boolean.TRUE;
                }
                if (!androidx.compose.ui.focus.j.a(m148getFocusDirectionP8AzH3I.o())) {
                    return Boolean.FALSE;
                }
                Integer c13 = androidx.compose.ui.focus.f.c(m148getFocusDirectionP8AzH3I.o());
                if (c13 == null) {
                    throw new IllegalStateException("Invalid focus direction");
                }
                int intValue = c13.intValue();
                Rect b11 = y10 != null ? u4.b(y10) : null;
                if (b11 == null) {
                    throw new IllegalStateException("Invalid rect");
                }
                k11 = AndroidComposeView.this.k(intValue);
                if (Intrinsics.c(k11, AndroidComposeView.this)) {
                    k11 = null;
                }
                if ((k11 == null || !androidx.compose.ui.focus.f.b(k11, Integer.valueOf(intValue), b11)) && AndroidComposeView.this.getFocusOwner().j(false, true, false, m148getFocusDirectionP8AzH3I.o())) {
                    Boolean e12 = AndroidComposeView.this.getFocusOwner().e(m148getFocusDirectionP8AzH3I.o(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(FocusTargetNode focusTargetNode) {
                            Boolean k12 = FocusTransactionsKt.k(focusTargetNode, androidx.compose.ui.focus.b.this.o());
                            return Boolean.valueOf(k12 != null ? k12.booleanValue() : true);
                        }
                    });
                    return Boolean.valueOf(e12 != null ? e12.booleanValue() : true);
                }
                return Boolean.TRUE;
            }
        });
        this.keyInputModifier = a11;
        androidx.compose.ui.f a12 = androidx.compose.ui.input.rotary.a.a(aVar2, new Function1<f0.b, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(f0.b bVar) {
                return Boolean.FALSE;
            }
        });
        this.rotaryInputModifier = a12;
        this.canvasHolder = new androidx.compose.ui.graphics.n1();
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.g(RootMeasurePolicy.f5225b);
        layoutNode.b(getDensity());
        layoutNode.h(aVar2.e(emptySemanticsElement).e(a12).e(a11).e(getFocusOwner().h()).e(dragAndDropModifierOnDragListener.d()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new androidx.compose.ui.semantics.m(getRoot(), dVar);
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new i(context);
        this.graphicsContext = androidx.compose.ui.graphics.m0.a(this);
        this.autofillTree = new x.w();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new androidx.compose.ui.input.pointer.h();
        this.pointerInputEventProcessor = new androidx.compose.ui.input.pointer.a0(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Configuration) obj);
                return Unit.f67184a;
            }

            public final void invoke(Configuration configuration) {
            }
        };
        this._autofill = f() ? new x.d(this, getAutofillTree()) : null;
        this.clipboardManager = new j(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new androidx.compose.ui.node.k0(getRoot());
        this.viewConfiguration = new l0(ViewConfiguration.get(context));
        this.globalPosition = o0.q.a(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        float[] c13 = i4.c(null, 1, null);
        this.tmpMatrix = c13;
        this.viewToWindowMatrix = i4.c(null, 1, null);
        this.windowToViewMatrix = i4.c(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = aVar.a();
        this.isRenderNodeCompatible = true;
        c11 = androidx.compose.runtime.u2.c(null, null, 2, null);
        this._viewTreeOwners = c11;
        this.viewTreeOwners = androidx.compose.runtime.r2.c(new Function0<b>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.b invoke() {
                AndroidComposeView.b bVar;
                bVar = AndroidComposeView.this.get_viewTreeOwners();
                return bVar;
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.m
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.n(AndroidComposeView.this);
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.n
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.H(AndroidComposeView.this);
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.o
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z10) {
                AndroidComposeView.N(AndroidComposeView.this, z10);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new androidx.compose.ui.text.input.e0((androidx.compose.ui.text.input.y) AndroidComposeView_androidKt.h().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.a();
        this.softwareKeyboardController = new s0(getTextInputService());
        this.fontLoader = new h0(context);
        this.fontFamilyResolver = androidx.compose.runtime.r2.e(androidx.compose.ui.text.font.k.a(context), androidx.compose.runtime.r2.h());
        this.currentFontWeightAdjustment = m(context.getResources().getConfiguration());
        LayoutDirection e11 = androidx.compose.ui.focus.f.e(context.getResources().getConfiguration().getLayoutDirection());
        c12 = androidx.compose.runtime.u2.c(e11 == null ? LayoutDirection.Ltr : e11, null, 2, null);
        this.layoutDirection = c12;
        this.hapticFeedBack = new b0.b(this);
        this._inputModeManager = new c0.c(isInTouchMode() ? c0.a.f17049b.b() : c0.a.f17049b.a(), new Function1<c0.a, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m150invokeiuPiT84(((c0.a) obj).i());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m150invokeiuPiT84(int i11) {
                a.C0164a c0164a = c0.a.f17049b;
                return Boolean.valueOf(c0.a.f(i11, c0164a.b()) ? AndroidComposeView.this.isInTouchMode() : c0.a.f(i11, c0164a.a()) ? AndroidComposeView.this.isInTouchMode() ? AndroidComposeView.this.requestFocusFromTouch() : true : false);
            }
        }, objArr2 == true ? 1 : 0);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new u2();
        this.endApplyChangesListeners = new androidx.compose.runtime.collection.b(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MotionEvent motionEvent;
                long j11;
                AndroidComposeView.this.removeCallbacks(this);
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z10 = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z10) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i11 = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i11 = 2;
                    }
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    j11 = androidComposeView.relayoutTime;
                    androidComposeView.K(motionEvent, i11, j11, false);
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.p
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.I(AndroidComposeView.this);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m157invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m157invoke() {
                MotionEvent motionEvent;
                AndroidComposeView$resendMotionEventRunnable$1 androidComposeView$resendMotionEventRunnable$1;
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        AndroidComposeView.this.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView = AndroidComposeView.this;
                        androidComposeView$resendMotionEventRunnable$1 = androidComposeView.resendMotionEventRunnable;
                        androidComposeView.post(androidComposeView$resendMotionEventRunnable$1);
                    }
                }
            }
        };
        int i11 = Build.VERSION.SDK_INT;
        this.matrixToWindow = i11 < 29 ? new n0(c13, objArr == true ? 1 : 0) : new p0();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        if (i11 >= 26) {
            g0.f5860a.a(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1 a13 = t2.f5934f1.a();
        if (a13 != null) {
            a13.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener);
        getRoot().r(this);
        if (i11 >= 29) {
            x.f5951a.a(this);
        }
        this.scrollCapture = i11 >= 31 ? new ScrollCapture() : null;
        this.pointerIconService = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(androidx.compose.ui.focus.b focusDirection, y.i previouslyFocusedRect) {
        Integer c11;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (c11 = androidx.compose.ui.focus.f.c(focusDirection.o())) == null) ? 130 : c11.intValue(), previouslyFocusedRect != null ? u4.b(previouslyFocusedRect) : null);
    }

    private final long B(int a11, int b11) {
        return ULong.b(ULong.b(b11) | ULong.b(ULong.b(a11) << 32));
    }

    private final void C() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
            E();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f11 = iArr[0];
            float f12 = iArr[1];
            view.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = y.h.a(f11 - iArr2[0], f12 - iArr2[1]);
        }
    }

    private final void D(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        E();
        long f11 = i4.f(this.viewToWindowMatrix, y.h.a(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = y.h.a(motionEvent.getRawX() - y.g.m(f11), motionEvent.getRawY() - y.g.n(f11));
    }

    private final void E() {
        this.matrixToWindow.a(this, this.viewToWindowMatrix);
        b1.a(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void F(LayoutNode nodeToRemeasure) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (nodeToRemeasure != null) {
            while (nodeToRemeasure != null && nodeToRemeasure.a0() == LayoutNode.UsageByParent.InMeasureBlock && g(nodeToRemeasure)) {
                nodeToRemeasure = nodeToRemeasure.h0();
            }
            if (nodeToRemeasure == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    static /* synthetic */ void G(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.F(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(AndroidComposeView androidComposeView) {
        androidComposeView.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.e(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.");
        }
        androidComposeView.J(motionEvent);
    }

    private final int J(MotionEvent motionEvent) {
        Object obj;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.a(androidx.compose.ui.input.pointer.g0.b(motionEvent.getMetaState()));
        }
        androidx.compose.ui.input.pointer.y c11 = this.motionEventAdapter.c(motionEvent, this);
        if (c11 == null) {
            this.pointerInputEventProcessor.c();
            return androidx.compose.ui.input.pointer.b0.a(false, false);
        }
        List b11 = c11.b();
        int size = b11.size() - 1;
        if (size >= 0) {
            while (true) {
                int i11 = size - 1;
                obj = b11.get(size);
                if (((androidx.compose.ui.input.pointer.z) obj).b()) {
                    break;
                }
                if (i11 < 0) {
                    break;
                }
                size = i11;
            }
        }
        obj = null;
        androidx.compose.ui.input.pointer.z zVar = (androidx.compose.ui.input.pointer.z) obj;
        if (zVar != null) {
            this.lastDownPointerPosition = zVar.f();
        }
        int b12 = this.pointerInputEventProcessor.b(c11, this, v(motionEvent));
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || androidx.compose.ui.input.pointer.j0.c(b12)) {
            return b12;
        }
        this.motionEventAdapter.e(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return b12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int actionMasked = motionEvent.getActionMasked();
        int i11 = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i11 = motionEvent.getActionIndex();
            }
        } else if (action != 9 && action != 10) {
            i11 = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i11 >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i12 = 0; i12 < pointerCount; i12++) {
            pointerPropertiesArr[i12] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i13 = 0; i13 < pointerCount; i13++) {
            pointerCoordsArr[i13] = new MotionEvent.PointerCoords();
        }
        int i14 = 0;
        while (i14 < pointerCount) {
            int i15 = ((i11 < 0 || i14 < i11) ? 0 : 1) + i14;
            motionEvent.getPointerProperties(i15, pointerPropertiesArr[i14]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i14];
            motionEvent.getPointerCoords(i15, pointerCoords);
            long mo116localToScreenMKHz9U = mo116localToScreenMKHz9U(y.h.a(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = y.g.m(mo116localToScreenMKHz9U);
            pointerCoords.y = y.g.n(mo116localToScreenMKHz9U);
            i14++;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? eventTime : motionEvent.getDownTime(), eventTime, action, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), forceHover ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        androidx.compose.ui.input.pointer.y c11 = this.motionEventAdapter.c(obtain, this);
        Intrinsics.e(c11);
        this.pointerInputEventProcessor.b(c11, this, true);
        obtain.recycle();
    }

    static /* synthetic */ void L(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i11, long j11, boolean z10, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        androidComposeView.K(motionEvent, i11, j11, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(androidx.compose.ui.draganddrop.g transferData, long decorationSize, Function1 drawDragDecoration) {
        Resources resources = getContext().getResources();
        androidx.compose.ui.draganddrop.a aVar = new androidx.compose.ui.draganddrop.a(o0.g.a(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), decorationSize, drawDragDecoration, null);
        if (Build.VERSION.SDK_INT >= 24) {
            return y.f5955a.a(this, transferData, aVar);
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AndroidComposeView androidComposeView, boolean z10) {
        androidComposeView._inputModeManager.b(z10 ? c0.a.f17049b.b() : c0.a.f17049b.a());
    }

    private final void O() {
        getLocationOnScreen(this.tmpPositionArray);
        long j11 = this.globalPosition;
        int h11 = o0.p.h(j11);
        int i11 = o0.p.i(j11);
        int[] iArr = this.tmpPositionArray;
        boolean z10 = false;
        int i12 = iArr[0];
        if (h11 != i12 || i11 != iArr[1]) {
            this.globalPosition = o0.q.a(i12, iArr[1]);
            if (h11 != Integer.MAX_VALUE && i11 != Integer.MAX_VALUE) {
                getRoot().P().I().l1();
                z10 = true;
            }
        }
        this.measureAndLayoutDelegate.c(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        int e11;
        if (Intrinsics.c(extraDataKey, this.composeAccessibilityDelegate.P())) {
            int e12 = this.composeAccessibilityDelegate.R().e(virtualViewId, -1);
            if (e12 != -1) {
                info.getExtras().putInt(extraDataKey, e12);
                return;
            }
            return;
        }
        if (!Intrinsics.c(extraDataKey, this.composeAccessibilityDelegate.O()) || (e11 = this.composeAccessibilityDelegate.Q().e(virtualViewId, -1)) == -1) {
            return;
        }
        info.getExtras().putInt(extraDataKey, e11);
    }

    private final boolean f() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private final boolean g(LayoutNode layoutNode) {
        LayoutNode h02;
        return this.wasMeasuredWithMultipleConstraints || !((h02 = layoutNode.h0()) == null || h02.K());
    }

    @Deprecated
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b get_viewTreeOwners() {
        return (b) this._viewTreeOwners.getValue();
    }

    private final void h(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                h((ViewGroup) childAt);
            }
        }
    }

    private final long i(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return B(0, size);
        }
        if (mode == 0) {
            return B(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return B(size, size);
        }
        throw new IllegalStateException();
    }

    private final void j() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View k(int direction) {
        View view = this;
        while (view != null) {
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.f(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            view = focusFinder.findNextFocus((ViewGroup) rootView, view, direction);
            if (view != null && !AndroidComposeView_androidKt.a(this, view)) {
                return view;
            }
        }
        return null;
    }

    private final View l(int accessibilityId, View currentView) {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.c(declaredMethod.invoke(currentView, null), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) currentView;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View l11 = l(accessibilityId, viewGroup.getChildAt(i11));
                    if (l11 != null) {
                        return l11;
                    }
                }
            }
        }
        return null;
    }

    private final int m(Configuration configuration) {
        int i11;
        if (Build.VERSION.SDK_INT < 31) {
            return 0;
        }
        i11 = configuration.fontWeightAdjustment;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AndroidComposeView androidComposeView) {
        androidComposeView.O();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f3 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010b A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int o(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.o(android.view.MotionEvent):int");
    }

    private final boolean p(MotionEvent event) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        float f11 = -event.getAxisValue(26);
        return getFocusOwner().f(new f0.b(f11 * ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()), f11 * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), event.getEventTime(), event.getDeviceId()));
    }

    private final boolean q(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final void r(LayoutNode node) {
        node.x0();
        androidx.compose.runtime.collection.b p02 = node.p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            int i11 = 0;
            do {
                r((LayoutNode) m11[i11]);
                i11++;
            } while (i11 < n11);
        }
    }

    private final void s(LayoutNode node) {
        int i11 = 0;
        androidx.compose.ui.node.k0.H(this.measureAndLayoutDelegate, node, false, 2, null);
        androidx.compose.runtime.collection.b p02 = node.p0();
        int n11 = p02.n();
        if (n11 > 0) {
            Object[] m11 = p02.m();
            do {
                s((LayoutNode) m11[i11]);
                i11++;
            } while (i11 < n11);
        }
    }

    private void setDensity(o0.e eVar) {
        this.density.setValue(eVar);
    }

    private void setFontFamilyResolver(h.b bVar) {
        this.fontFamilyResolver.setValue(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    private final void set_viewTreeOwners(b bVar) {
        this._viewTreeOwners.setValue(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082 A[LOOP:0: B:20:0x004c->B:35:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[EDGE_INSN: B:36:0x0085->B:39:0x0085 BREAK  A[LOOP:0: B:20:0x004c->B:35:0x0082], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean t(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            float r0 = r7.getY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            float r0 = r7.getRawX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            float r0 = r7.getRawY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L44
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L44
            r0 = r2
            goto L45
        L44:
            r0 = r3
        L45:
            if (r0 != 0) goto L85
            int r1 = r7.getPointerCount()
            r4 = r3
        L4c:
            if (r4 >= r1) goto L85
            float r0 = r7.getX(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L7f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L7f
            float r0 = r7.getY(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L7f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L7f
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r0 < r5) goto L7d
            androidx.compose.ui.platform.f1 r0 = androidx.compose.ui.platform.f1.f5855a
            boolean r0 = r0.a(r7, r4)
            if (r0 != 0) goto L7d
            goto L7f
        L7d:
            r0 = r2
            goto L80
        L7f:
            r0 = r3
        L80:
            if (r0 != 0) goto L85
            int r4 = r4 + 1
            goto L4c
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.t(android.view.MotionEvent):boolean");
    }

    private final boolean u(MotionEvent event) {
        int actionMasked;
        return event.getButtonState() != 0 || (actionMasked = event.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    private final boolean v(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        return 0.0f <= x10 && x10 <= ((float) getWidth()) && 0.0f <= y10 && y10 <= ((float) getHeight());
    }

    private final boolean w(MotionEvent event) {
        MotionEvent motionEvent;
        return (event.getPointerCount() == 1 && (motionEvent = this.previousMotionEvent) != null && motionEvent.getPointerCount() == event.getPointerCount() && event.getRawX() == motionEvent.getRawX() && event.getRawY() == motionEvent.getRawY()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        if (isFocused() || hasFocus()) {
            super.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final y.i y() {
        if (isFocused()) {
            return getFocusOwner().m();
        }
        View findFocus = findFocus();
        if (findFocus != null) {
            return androidx.compose.ui.focus.f.a(findFocus);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z(int focusDirection) {
        b.a aVar = androidx.compose.ui.focus.b.f4312b;
        if (androidx.compose.ui.focus.b.l(focusDirection, aVar.b()) || androidx.compose.ui.focus.b.l(focusDirection, aVar.c())) {
            return false;
        }
        Integer c11 = androidx.compose.ui.focus.f.c(focusDirection);
        if (c11 == null) {
            throw new IllegalStateException("Invalid focus direction");
        }
        int intValue = c11.intValue();
        y.i y10 = y();
        Rect b11 = y10 != null ? u4.b(y10) : null;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View findNextFocus = b11 == null ? focusFinder.findNextFocus(this, findFocus(), intValue) : focusFinder.findNextFocusFromRect(this, b11, intValue);
        if (findNextFocus != null) {
            return androidx.compose.ui.focus.f.b(findNextFocus, Integer.valueOf(intValue), b11);
        }
        return false;
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
            
                if (r5.intValue() == r4.f5599a.getSemanticsOwner().a().o()) goto L13;
             */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onInitializeAccessibilityNodeInfo(android.view.View r5, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r6) {
                /*
                    r4 = this;
                    super.onInitializeAccessibilityNodeInfo(r5, r6)
                    androidx.compose.ui.platform.AndroidComposeView r5 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r5)
                    boolean r5 = r5.c0()
                    if (r5 == 0) goto L13
                    r5 = 0
                    r6.setVisibleToUser(r5)
                L13:
                    androidx.compose.ui.node.LayoutNode r5 = r2
                    androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                        static {
                            /*
                                androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                r0.<init>()
                                
                                // error: 0x0005: SPUT (r0 I:androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1) androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.INSTANCE androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<clinit>():void");
                        }

                        {
                            /*
                                r1 = this;
                                r0 = 1
                                r1.<init>(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<init>():void");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                            /*
                                r1 = this;
                                androidx.compose.ui.node.q0 r2 = r2.e0()
                                r0 = 8
                                int r0 = androidx.compose.ui.node.s0.a(r0)
                                boolean r2 = r2.q(r0)
                                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                            /*
                                r0 = this;
                                androidx.compose.ui.node.LayoutNode r1 = (androidx.compose.ui.node.LayoutNode) r1
                                java.lang.Boolean r1 = r0.invoke(r1)
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.invoke(java.lang.Object):java.lang.Object");
                        }
                    }
                    androidx.compose.ui.node.LayoutNode r5 = androidx.compose.ui.semantics.l.f(r5, r0)
                    if (r5 == 0) goto L26
                    int r5 = r5.j0()
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    goto L27
                L26:
                    r5 = 0
                L27:
                    r0 = -1
                    if (r5 == 0) goto L3e
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.semantics.m r1 = r1.getSemanticsOwner()
                    androidx.compose.ui.semantics.SemanticsNode r1 = r1.a()
                    int r1 = r1.o()
                    int r2 = r5.intValue()
                    if (r2 != r1) goto L42
                L3e:
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
                L42:
                    androidx.compose.ui.platform.AndroidComposeView r1 = r3
                    int r5 = r5.intValue()
                    r6.setParent(r1, r5)
                    androidx.compose.ui.node.LayoutNode r5 = r2
                    int r5 = r5.j0()
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.c0 r1 = r1.R()
                    int r1 = r1.e(r5, r0)
                    if (r1 == r0) goto L89
                    androidx.compose.ui.platform.AndroidComposeView r2 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r2 = r2.getAndroidViewsHandler$ui_release()
                    android.view.View r2 = androidx.compose.ui.platform.e2.g(r2, r1)
                    if (r2 == 0) goto L71
                    r6.setTraversalBefore(r2)
                    goto L76
                L71:
                    androidx.compose.ui.platform.AndroidComposeView r2 = r3
                    r6.setTraversalBefore(r2, r1)
                L76:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r2 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r3 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r3 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r3)
                    java.lang.String r3 = r3.P()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r1, r5, r2, r3)
                L89:
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    androidx.collection.c0 r1 = r1.Q()
                    int r1 = r1.e(r5, r0)
                    if (r1 == r0) goto Lc1
                    androidx.compose.ui.platform.AndroidComposeView r0 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidViewsHandler r0 = r0.getAndroidViewsHandler$ui_release()
                    android.view.View r0 = androidx.compose.ui.platform.e2.g(r0, r1)
                    if (r0 == 0) goto La9
                    r6.setTraversalAfter(r0)
                    goto Lae
                La9:
                    androidx.compose.ui.platform.AndroidComposeView r0 = r3
                    r6.setTraversalAfter(r0, r1)
                Lae:
                    androidx.compose.ui.platform.AndroidComposeView r0 = androidx.compose.ui.platform.AndroidComposeView.this
                    android.view.accessibility.AccessibilityNodeInfo r6 = r6.unwrap()
                    androidx.compose.ui.platform.AndroidComposeView r1 = androidx.compose.ui.platform.AndroidComposeView.this
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r1 = androidx.compose.ui.platform.AndroidComposeView.access$getComposeAccessibilityDelegate$p(r1)
                    java.lang.String r1 = r1.O()
                    androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r0, r5, r6, r1)
                Lc1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1.onInitializeAccessibilityNodeInfo(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        addView(child, -1);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        Intrinsics.e(child);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = width;
        generateDefaultLayoutParams.height = height;
        Unit unit = Unit.f67184a;
        addView(child, -1, generateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        x.d dVar;
        if (!f() || (dVar = this._autofill) == null) {
            return;
        }
        x.f.a(dVar, values);
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object z10 = this.composeAccessibilityDelegate.z(continuation);
        return z10 == IntrinsicsKt.f() ? z10 : Unit.f67184a;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) {
        Object b11 = this.contentCaptureManager.b(continuation);
        return b11 == IntrinsicsKt.f() ? b11 : Unit.f67184a;
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U, reason: not valid java name */
    public long m147calculateLocalPositionMKHz9U(long positionInWindow) {
        C();
        return i4.f(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.ui.node.y0
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo142calculatePositionInWindowMKHz9U(long localPosition) {
        C();
        return i4.f(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.A(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.A(true, direction, this.lastDownPointerPosition);
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.node.w0 createLayer(Function2<? super androidx.compose.ui.graphics.m1, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            return new GraphicsLayerOwnerLayer(explicitLayer, null, this, drawBlock, invalidateParentLayer);
        }
        androidx.compose.ui.node.w0 w0Var = (androidx.compose.ui.node.w0) this.layerCache.b();
        if (w0Var != null) {
            w0Var.reuseLayer(drawBlock, invalidateParentLayer);
            return w0Var;
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT != 28) {
            return new GraphicsLayerOwnerLayer(getGraphicsContext().a(), getGraphicsContext(), this, drawBlock, invalidateParentLayer);
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            ViewLayer.Companion companion = ViewLayer.INSTANCE;
            if (!companion.a()) {
                companion.d(new View(getContext()));
            }
            DrawChildContainer drawChildContainer = companion.b() ? new DrawChildContainer(getContext()) : new ViewLayerContainer(getContext());
            this.viewLayersContainer = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
        Intrinsics.e(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, drawBlock, invalidateParentLayer);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            r(getRoot());
        }
        androidx.compose.ui.node.x0.c(this, false, 1, null);
        androidx.compose.runtime.snapshots.j.f4079e.n();
        this.isDrawingContent = true;
        androidx.compose.ui.graphics.n1 n1Var = this.canvasHolder;
        Canvas v11 = n1Var.a().v();
        n1Var.a().w(canvas);
        getRoot().y(n1Var.a(), null);
        n1Var.a().w(v11);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.compose.ui.node.w0) this.dirtyLayers.get(i11)).updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.b()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.e(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        return motionEvent.getActionMasked() == 8 ? (t(motionEvent) || !isAttachedToWindow()) ? super.dispatchGenericMotionEvent(motionEvent) : motionEvent.isFromSource(4194304) ? p(motionEvent) : androidx.compose.ui.input.pointer.j0.c(o(motionEvent)) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (t(event) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.I(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && v(event)) {
                if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent = this.previousMotionEvent;
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                this.hoverExitReceived = true;
                postDelayed(this.sendHoverExitEvent, 8L);
                return false;
            }
        } else if (!w(event)) {
            return false;
        }
        return androidx.compose.ui.input.pointer.j0.c(o(event));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final KeyEvent event) {
        if (!isFocused()) {
            return getFocusOwner().i(d0.b.b(event), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$dispatchKeyEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    boolean dispatchKeyEvent;
                    dispatchKeyEvent = super/*android.view.ViewGroup*/.dispatchKeyEvent(event);
                    return Boolean.valueOf(dispatchKeyEvent);
                }
            });
        }
        this._windowInfo.a(androidx.compose.ui.input.pointer.g0.b(event.getMetaState()));
        return FocusOwner$CC.a(getFocusOwner(), d0.b.b(event), null, 2, null) || super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        return (isFocused() && getFocusOwner().d(d0.b.b(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure structure) {
        if (Build.VERSION.SDK_INT < 28) {
            v.f5942a.a(structure, getView());
        } else {
            super.dispatchProvideStructure(structure);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.e(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || q(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (t(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !w(motionEvent)) {
            return false;
        }
        int o11 = o(motionEvent);
        if (androidx.compose.ui.input.pointer.j0.b(o11)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return androidx.compose.ui.input.pointer.j0.c(o11);
    }

    public final void drawAndroidView(AndroidViewHolder view, Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        View view = null;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (invoke instanceof View) {
                    view = (View) invoke;
                }
            } else {
                view = l(accessibilityId, this);
            }
        } catch (NoSuchMethodException unused) {
        }
        return view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        if (focused != null) {
            y.i a11 = androidx.compose.ui.focus.f.a(focused);
            androidx.compose.ui.focus.b d11 = androidx.compose.ui.focus.f.d(direction);
            if (Intrinsics.c(getFocusOwner().e(d11 != null ? d11.o() : androidx.compose.ui.focus.b.f4312b.a(), a11, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusSearch$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.TRUE;
                }
            }), Boolean.TRUE)) {
                return this;
            }
        }
        return super.focusSearch(focused, direction);
    }

    public void forceAccessibilityForTesting(boolean enable) {
        this.composeAccessibilityDelegate.C0(enable);
    }

    @Override // androidx.compose.ui.node.y0
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.i(layoutNode, affectsLookahead);
    }

    @Override // androidx.compose.ui.node.y0
    public i getAccessibilityManager() {
        return this.accessibilityManager;
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.e(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.y0
    public x.g getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.y0
    public x.w getAutofillTree() {
        return this.autofillTree;
    }

    @Override // androidx.compose.ui.node.y0
    public j getClipboardManager() {
        return this.clipboardManager;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    /* renamed from: getContentCaptureManager$ui_release, reason: from getter */
    public final AndroidContentCaptureManager getContentCaptureManager() {
        return this.contentCaptureManager;
    }

    @Override // androidx.compose.ui.node.y0
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.ui.node.y0
    public o0.e getDensity() {
        return (o0.e) this.density.getValue();
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.draganddrop.c getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    /* renamed from: getFocusDirection-P8AzH3I, reason: not valid java name */
    public androidx.compose.ui.focus.b m148getFocusDirectionP8AzH3I(KeyEvent keyEvent) {
        long a11 = d0.d.a(keyEvent);
        a.C0752a c0752a = d0.a.f61093b;
        if (d0.a.p(a11, c0752a.l())) {
            return androidx.compose.ui.focus.b.i(d0.d.d(keyEvent) ? androidx.compose.ui.focus.b.f4312b.f() : androidx.compose.ui.focus.b.f4312b.e());
        }
        if (d0.a.p(a11, c0752a.e())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f4312b.g());
        }
        if (d0.a.p(a11, c0752a.d())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f4312b.d());
        }
        if (d0.a.p(a11, c0752a.f()) ? true : d0.a.p(a11, c0752a.k())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f4312b.h());
        }
        if (d0.a.p(a11, c0752a.c()) ? true : d0.a.p(a11, c0752a.j())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f4312b.a());
        }
        if (d0.a.p(a11, c0752a.b()) ? true : d0.a.p(a11, c0752a.g()) ? true : d0.a.p(a11, c0752a.i())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f4312b.b());
        }
        if (d0.a.p(a11, c0752a.a()) ? true : d0.a.p(a11, c0752a.h())) {
            return androidx.compose.ui.focus.b.i(androidx.compose.ui.focus.b.f4312b.c());
        }
        return null;
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.focus.i getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        Unit unit;
        y.i y10 = y();
        if (y10 != null) {
            rect.left = Math.round(y10.f());
            rect.top = Math.round(y10.i());
            rect.right = Math.round(y10.g());
            rect.bottom = Math.round(y10.c());
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.compose.ui.node.y0
    public h.b getFontFamilyResolver() {
        return (h.b) this.fontFamilyResolver.getValue();
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.text.font.g getFontLoader() {
        return this.fontLoader;
    }

    @Override // androidx.compose.ui.node.y0
    public a4 getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.node.y0
    public b0.a getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.m();
    }

    @Override // androidx.compose.ui.node.y0
    public c0.b getInputModeManager() {
        return this._inputModeManager;
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.y0
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.q();
    }

    @Override // androidx.compose.ui.node.y0
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.y0
    public g0.a getPlacementScope() {
        return PlaceableKt.b(this);
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.input.pointer.t getPointerIconService() {
        return this.pointerIconService;
    }

    @Override // androidx.compose.ui.node.y0
    public LayoutNode getRoot() {
        return this.root;
    }

    public androidx.compose.ui.node.g1 getRootForTest() {
        return this.rootForTest;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture.c();
    }

    public androidx.compose.ui.semantics.m getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.node.d0 getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.node.y0
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.y0
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.y0
    public g2 getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.ui.node.y0
    public androidx.compose.ui.text.input.e0 getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.y0
    public h2 getTextToolbar() {
        return this.textToolbar;
    }

    public View getView() {
        return this;
    }

    @Override // androidx.compose.ui.node.y0
    public o2 getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final b getViewTreeOwners() {
        return (b) this.viewTreeOwners.getValue();
    }

    @Override // androidx.compose.ui.node.y0
    public v2 getWindowInfo() {
        return this._windowInfo;
    }

    public void invalidateDescendants() {
        r(getRoot());
    }

    public boolean isLifecycleInResumedState() {
        androidx.view.u a11;
        Lifecycle lifecycle;
        b viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (a11 = viewTreeOwners.a()) == null || (lifecycle = a11.getLifecycle()) == null) ? null : lifecycle.b()) == Lifecycle.State.RESUMED;
    }

    @Override // androidx.compose.ui.input.pointer.i0
    /* renamed from: localToScreen-58bKbWc */
    public void mo115localToScreen58bKbWc(float[] localTransform) {
        C();
        i4.n(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.d(localTransform, y.g.m(this.windowPosition), y.g.n(this.windowPosition), this.tmpMatrix);
    }

    @Override // androidx.compose.ui.input.pointer.i0
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo116localToScreenMKHz9U(long localPosition) {
        C();
        long f11 = i4.f(this.viewToWindowMatrix, localPosition);
        return y.h.a(y.g.m(f11) + y.g.m(this.windowPosition), y.g.n(f11) + y.g.n(this.windowPosition));
    }

    @Override // androidx.compose.ui.node.y0
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0 function0;
        if (this.measureAndLayoutDelegate.m() || this.measureAndLayoutDelegate.n()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (sendPointerUpdate) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.r(function0)) {
                requestLayout();
            }
            androidx.compose.ui.node.k0.d(this.measureAndLayoutDelegate, false, 1, null);
            j();
            Unit unit = Unit.f67184a;
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.y0
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo143measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.s(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.m()) {
                androidx.compose.ui.node.k0.d(this.measureAndLayoutDelegate, false, 1, null);
                j();
            }
            Unit unit = Unit.f67184a;
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public void measureAndLayoutForTest() {
        androidx.compose.ui.node.x0.c(this, false, 1, null);
    }

    public final void notifyLayerIsDirty$ui_release(androidx.compose.ui.node.w0 layer, boolean isDirty) {
        if (!isDirty) {
            if (this.isDrawingContent) {
                return;
            }
            this.dirtyLayers.remove(layer);
            List list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(layer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        List list2 = this.postponedDirtyLayers;
        if (list2 == null) {
            list2 = new ArrayList();
            this.postponedDirtyLayers = list2;
        }
        list2.add(layer);
    }

    @Override // androidx.compose.ui.node.y0
    public void onAttach(LayoutNode node) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        androidx.view.u a11;
        Lifecycle lifecycle;
        androidx.view.u a12;
        x.d dVar;
        super.onAttachedToWindow();
        this._windowInfo.b(hasWindowFocus());
        s(getRoot());
        r(getRoot());
        getSnapshotObserver().k();
        if (f() && (dVar = this._autofill) != null) {
            x.v.f78120a.a(dVar);
        }
        androidx.view.u a13 = ViewTreeLifecycleOwner.a(this);
        InterfaceC1015e a14 = ViewTreeSavedStateRegistryOwner.a(this);
        b viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (a13 != null && a14 != null && (a13 != viewTreeOwners.a() || a14 != viewTreeOwners.a()))) {
            if (a13 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (a14 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (a11 = viewTreeOwners.a()) != null && (lifecycle = a11.getLifecycle()) != null) {
                lifecycle.d(this);
            }
            a13.getLifecycle().a(this);
            b bVar = new b(a13, a14);
            set_viewTreeOwners(bVar);
            Function1 function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(bVar);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.b(isInTouchMode() ? c0.a.f17049b.b() : c0.a.f17049b.a());
        b viewTreeOwners2 = getViewTreeOwners();
        if (viewTreeOwners2 != null && (a12 = viewTreeOwners2.a()) != null) {
            lifecycle2 = a12.getLifecycle();
        }
        if (lifecycle2 == null) {
            g0.a.c("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle2.a(this);
        lifecycle2.a(this.contentCaptureManager);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            d0.f5840a.b(this);
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        i0 i0Var = (i0) SessionMutex.c(this.textInputSessionMutex);
        return i0Var == null ? this.legacyTextInputServiceAndroid.i() : i0Var.b();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setDensity(o0.a.a(getContext()));
        if (m(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = m(newConfig);
            setFontFamilyResolver(androidx.compose.ui.text.font.k.a(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // androidx.view.f
    public /* bridge */ /* synthetic */ void onCreate(androidx.view.u uVar) {
        androidx.view.e.a(this, uVar);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        i0 i0Var = (i0) SessionMutex.c(this.textInputSessionMutex);
        return i0Var == null ? this.legacyTextInputServiceAndroid.f(outAttrs) : i0Var.a(outAttrs);
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.o(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // androidx.view.f
    public /* bridge */ /* synthetic */ void onDestroy(androidx.view.u uVar) {
        androidx.view.e.b(this, uVar);
    }

    @Override // androidx.compose.ui.node.y0
    public void onDetach(LayoutNode node) {
        this.measureAndLayoutDelegate.v(node);
        requestClearInvalidObservations();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        x.d dVar;
        androidx.view.u a11;
        super.onDetachedFromWindow();
        getSnapshotObserver().l();
        b viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle = (viewTreeOwners == null || (a11 = viewTreeOwners.a()) == null) ? null : a11.getLifecycle();
        if (lifecycle == null) {
            g0.a.c("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle.d(this.contentCaptureManager);
        lifecycle.d(this);
        if (f() && (dVar = this._autofill) != null) {
            x.v.f78120a.b(dVar);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            d0.f5840a.a(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // androidx.compose.ui.node.y0
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().b();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            h(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.q()) {
            int n11 = this.endApplyChangesListeners.n();
            for (int i11 = 0; i11 < n11; i11++) {
                Function0 function0 = (Function0) this.endApplyChangesListeners.m()[i11];
                this.endApplyChangesListeners.y(i11, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.w(0, n11);
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus || hasFocus()) {
            return;
        }
        getFocusOwner().n();
    }

    @Override // androidx.compose.ui.node.y0
    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l11, int t11, int r11, int b11) {
        this.measureAndLayoutDelegate.r(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        O();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r11 - l11, b11 - t11);
        }
    }

    @Override // androidx.compose.ui.node.y0
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.g0(layoutNode);
        this.contentCaptureManager.q(layoutNode);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                s(getRoot());
            }
            long i11 = i(widthMeasureSpec);
            int b11 = (int) ULong.b(i11 >>> 32);
            int b12 = (int) ULong.b(i11 & 4294967295L);
            long i12 = i(heightMeasureSpec);
            long a11 = o0.b.f70719b.a(b11, b12, (int) ULong.b(i12 >>> 32), (int) ULong.b(4294967295L & i12));
            o0.b bVar = this.onMeasureConstraints;
            boolean z10 = false;
            if (bVar == null) {
                this.onMeasureConstraints = o0.b.a(a11);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (bVar != null) {
                    z10 = o0.b.f(bVar.r(), a11);
                }
                if (!z10) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.I(a11);
            this.measureAndLayoutDelegate.t();
            setMeasuredDimension(getRoot().m0(), getRoot().L());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().m0(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().L(), 1073741824));
            }
            Unit unit = Unit.f67184a;
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @Override // androidx.view.f
    public /* bridge */ /* synthetic */ void onPause(androidx.view.u uVar) {
        androidx.view.e.c(this, uVar);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        x.d dVar;
        if (!f() || structure == null || (dVar = this._autofill) == null) {
            return;
        }
        x.f.b(dVar, structure);
    }

    @Override // androidx.compose.ui.node.y0
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.D(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                F(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.G(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            F(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.y0
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.C(layoutNode, forceRequest)) {
                G(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.F(layoutNode, forceRequest)) {
            G(this, null, 1, null);
        }
    }

    @Override // androidx.view.f
    public void onResume(androidx.view.u owner) {
        setShowLayoutBounds(INSTANCE.b());
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection e11 = androidx.compose.ui.focus.f.e(layoutDirection);
            if (e11 == null) {
                e11 = LayoutDirection.Ltr;
            }
            setLayoutDirection(e11);
        }
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(Rect localVisibleRect, Point windowOffset, Consumer<ScrollCaptureTarget> targets) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.d(this, getSemanticsOwner(), getCoroutineContext(), targets);
    }

    @Override // androidx.compose.ui.node.y0
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.h0();
        this.contentCaptureManager.r();
    }

    @Override // androidx.view.f
    public /* bridge */ /* synthetic */ void onStart(androidx.view.u uVar) {
        androidx.view.e.e(this, uVar);
    }

    @Override // androidx.view.f
    public /* bridge */ /* synthetic */ void onStop(androidx.view.u uVar) {
        androidx.view.e.f(this, uVar);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.t(androidContentCaptureManager, response);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean b11;
        this._windowInfo.b(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus || getShowLayoutBounds() == (b11 = INSTANCE.b())) {
            return;
        }
        setShowLayoutBounds(b11);
        invalidateDescendants();
    }

    public final boolean recycle$ui_release(androidx.compose.ui.node.w0 layer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.INSTANCE.b();
        }
        this.layerCache.c(layer);
        return true;
    }

    @Override // androidx.compose.ui.node.y0
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        if (this.endApplyChangesListeners.i(listener)) {
            return;
        }
        this.endApplyChangesListeners.b(listener);
    }

    public void registerOnLayoutCompletedListener(y0.b listener) {
        this.measureAndLayoutDelegate.x(listener);
        G(this, null, 1, null);
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m156invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m156invoke() {
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.d(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                view.setImportantForAccessibility(0);
            }
        });
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().k().getHasFocus()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        androidx.compose.ui.focus.b d11 = androidx.compose.ui.focus.f.d(direction);
        final int o11 = d11 != null ? d11.o() : androidx.compose.ui.focus.b.f4312b.b();
        Boolean e11 = getFocusOwner().e(o11, previouslyFocusedRect != null ? u4.e(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Boolean k11 = FocusTransactionsKt.k(focusTargetNode, o11);
                return Boolean.valueOf(k11 != null ? k11.booleanValue() : false);
            }
        });
        if (e11 != null) {
            return e11.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.y0
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.E(layoutNode);
        G(this, null, 1, null);
    }

    @Override // androidx.compose.ui.input.pointer.i0
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo117screenToLocalMKHz9U(long positionOnScreen) {
        C();
        return i4.f(this.windowToViewMatrix, y.h.a(y.g.m(positionOnScreen) - y.g.m(this.windowPosition), y.g.n(positionOnScreen) - y.g.n(this.windowPosition)));
    }

    /* renamed from: sendKeyEvent-ZmokQxo, reason: not valid java name */
    public boolean m149sendKeyEventZmokQxo(KeyEvent keyEvent) {
        return getFocusOwner().d(keyEvent) || FocusOwner$CC.a(getFocusOwner(), keyEvent, null, 2, null);
    }

    public void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
        this.composeAccessibilityDelegate.G0(intervalMillis);
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.f$c] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.b] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
        androidx.compose.ui.node.f k11 = getRoot().e0().k();
        if (k11 instanceof androidx.compose.ui.input.pointer.n0) {
            ((androidx.compose.ui.input.pointer.n0) k11).j0();
        }
        int a11 = androidx.compose.ui.node.s0.a(16);
        if (!k11.getNode().k1()) {
            g0.a.b("visitSubtree called on an unattached node");
        }
        f.c b12 = k11.getNode().b1();
        LayoutNode m11 = androidx.compose.ui.node.g.m(k11);
        androidx.compose.ui.node.p0 p0Var = new androidx.compose.ui.node.p0();
        while (m11 != null) {
            if (b12 == null) {
                b12 = m11.e0().k();
            }
            if ((b12.a1() & a11) != 0) {
                while (b12 != null) {
                    if ((b12.f1() & a11) != 0) {
                        androidx.compose.ui.node.i iVar = b12;
                        ?? r62 = 0;
                        while (iVar != 0) {
                            if (iVar instanceof androidx.compose.ui.node.e1) {
                                androidx.compose.ui.node.e1 e1Var = (androidx.compose.ui.node.e1) iVar;
                                if (e1Var instanceof androidx.compose.ui.input.pointer.n0) {
                                    ((androidx.compose.ui.input.pointer.n0) e1Var).j0();
                                }
                            } else if ((iVar.f1() & a11) != 0 && (iVar instanceof androidx.compose.ui.node.i)) {
                                f.c E1 = iVar.E1();
                                int i11 = 0;
                                iVar = iVar;
                                r62 = r62;
                                while (E1 != null) {
                                    if ((E1.f1() & a11) != 0) {
                                        i11++;
                                        r62 = r62;
                                        if (i11 == 1) {
                                            iVar = E1;
                                        } else {
                                            if (r62 == 0) {
                                                r62 = new androidx.compose.runtime.collection.b(new f.c[16], 0);
                                            }
                                            if (iVar != 0) {
                                                r62.b(iVar);
                                                iVar = 0;
                                            }
                                            r62.b(E1);
                                        }
                                    }
                                    E1 = E1.b1();
                                    iVar = iVar;
                                    r62 = r62;
                                }
                                if (i11 == 1) {
                                }
                            }
                            iVar = androidx.compose.ui.node.g.b(r62);
                        }
                    }
                    b12 = b12.b1();
                }
            }
            p0Var.c(m11.p0());
            m11 = p0Var.a() ? (LayoutNode) p0Var.b() : null;
            b12 = null;
        }
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j11) {
        this.lastMatrixRecalculationAnimationTime = j11;
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super b, Unit> callback) {
        b viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    @Override // androidx.compose.ui.node.y0
    public void setShowLayoutBounds(boolean z10) {
        this.showLayoutBounds = z10;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object textInputSession(kotlin.jvm.functions.Function2<java.lang.Object, ? super kotlin.coroutines.Continuation<?>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = (androidx.compose.ui.platform.AndroidComposeView$textInputSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.b(r6)
            goto L44
        L31:
            kotlin.ResultKt.b(r6)
            java.util.concurrent.atomic.AtomicReference r6 = r4.textInputSessionMutex
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$2 r2 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
            r2.<init>()
            r0.label = r3
            java.lang.Object r5 = androidx.compose.ui.SessionMutex.d(r6, r2, r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.textInputSession(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
