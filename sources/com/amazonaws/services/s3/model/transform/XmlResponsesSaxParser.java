package com.amazonaws.services.s3.model.transform;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PartSummary;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.RedirectRule;
import com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazonaws.services.s3.model.ReplicationRule;
import com.amazonaws.services.s3.model.RoutingRule;
import com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.transsion.search.bean.HotRankItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes2.dex */
public class XmlResponsesSaxParser {

    /* renamed from: c, reason: collision with root package name */
    private static final Log f18933c = LogFactory.b(XmlResponsesSaxParser.class);

    /* renamed from: a, reason: collision with root package name */
    private XMLReader f18934a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f18935b = true;

    /* loaded from: classes2.dex */
    public static class AccessControlListHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final AccessControlList f18936c = new AccessControlList();

        /* renamed from: d, reason: collision with root package name */
        private Grantee f18937d = null;

        /* renamed from: e, reason: collision with root package name */
        private Permission f18938e = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("AccessControlPolicy", "Owner")) {
                if (str2.equals("ID")) {
                    this.f18936c.getOwner().setId(d());
                    return;
                } else {
                    if (str2.equals("DisplayName")) {
                        this.f18936c.getOwner().setDisplayName(d());
                        return;
                    }
                    return;
                }
            }
            if (e("AccessControlPolicy", "AccessControlList")) {
                if (str2.equals("Grant")) {
                    this.f18936c.grantPermission(this.f18937d, this.f18938e);
                    this.f18937d = null;
                    this.f18938e = null;
                    return;
                }
                return;
            }
            if (e("AccessControlPolicy", "AccessControlList", "Grant")) {
                if (str2.equals("Permission")) {
                    this.f18938e = Permission.parsePermission(d());
                }
            } else if (e("AccessControlPolicy", "AccessControlList", "Grant", "Grantee")) {
                if (str2.equals("ID")) {
                    this.f18937d.setIdentifier(d());
                    return;
                }
                if (str2.equals("EmailAddress")) {
                    this.f18937d.setIdentifier(d());
                } else if (str2.equals("URI")) {
                    this.f18937d = GroupGrantee.parseGroupGrantee(d());
                } else if (str2.equals("DisplayName")) {
                    ((CanonicalGrantee) this.f18937d).setDisplayName(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("AccessControlPolicy")) {
                if (str2.equals("Owner")) {
                    this.f18936c.setOwner(new Owner());
                }
            } else if (e("AccessControlPolicy", "AccessControlList", "Grant") && str2.equals("Grantee")) {
                String i11 = XmlResponsesSaxParser.i("xsi:type", attributes);
                if ("AmazonCustomerByEmail".equals(i11)) {
                    this.f18937d = new EmailAddressGrantee(null);
                } else if ("CanonicalUser".equals(i11)) {
                    this.f18937d = new CanonicalGrantee(null);
                } else {
                    HotRankItem.CATE_GROUP.equals(i11);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketAccelerateConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final BucketAccelerateConfiguration f18939c = new BucketAccelerateConfiguration(null);

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("AccelerateConfiguration") && str2.equals("Status")) {
                this.f18939c.a(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketCrossOriginConfigurationHandler extends AbstractHandler {

        /* renamed from: d, reason: collision with root package name */
        private CORSRule f18941d;

        /* renamed from: c, reason: collision with root package name */
        private final BucketCrossOriginConfiguration f18940c = new BucketCrossOriginConfiguration(new ArrayList());

        /* renamed from: e, reason: collision with root package name */
        private List f18942e = null;

        /* renamed from: f, reason: collision with root package name */
        private List f18943f = null;

        /* renamed from: g, reason: collision with root package name */
        private List f18944g = null;

        /* renamed from: h, reason: collision with root package name */
        private List f18945h = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.f18941d.a(this.f18945h);
                    this.f18941d.b(this.f18942e);
                    this.f18941d.c(this.f18943f);
                    this.f18941d.d(this.f18944g);
                    this.f18945h = null;
                    this.f18942e = null;
                    this.f18943f = null;
                    this.f18944g = null;
                    this.f18940c.getRules().add(this.f18941d);
                    this.f18941d = null;
                    return;
                }
                return;
            }
            if (e("CORSConfiguration", "CORSRule")) {
                if (str2.equals("ID")) {
                    this.f18941d.e(d());
                    return;
                }
                if (str2.equals("AllowedOrigin")) {
                    this.f18943f.add(d());
                    return;
                }
                if (str2.equals("AllowedMethod")) {
                    this.f18942e.add(CORSRule.AllowedMethods.fromValue(d()));
                    return;
                }
                if (str2.equals("MaxAgeSeconds")) {
                    this.f18941d.f(Integer.parseInt(d()));
                } else if (str2.equals("ExposeHeader")) {
                    this.f18944g.add(d());
                } else if (str2.equals("AllowedHeader")) {
                    this.f18945h.add(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.f18941d = new CORSRule();
                    return;
                }
                return;
            }
            if (e("CORSConfiguration", "CORSRule")) {
                if (str2.equals("AllowedOrigin")) {
                    if (this.f18943f == null) {
                        this.f18943f = new ArrayList();
                    }
                } else if (str2.equals("AllowedMethod")) {
                    if (this.f18942e == null) {
                        this.f18942e = new ArrayList();
                    }
                } else if (str2.equals("ExposeHeader")) {
                    if (this.f18944g == null) {
                        this.f18944g = new ArrayList();
                    }
                } else if (str2.equals("AllowedHeader") && this.f18945h == null) {
                    this.f18945h = new LinkedList();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketLifecycleConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final BucketLifecycleConfiguration f18946c = new BucketLifecycleConfiguration(new ArrayList());

        /* renamed from: d, reason: collision with root package name */
        private BucketLifecycleConfiguration.Rule f18947d;

        /* renamed from: e, reason: collision with root package name */
        private BucketLifecycleConfiguration.Transition f18948e;

        /* renamed from: f, reason: collision with root package name */
        private BucketLifecycleConfiguration.NoncurrentVersionTransition f18949f;

        /* renamed from: g, reason: collision with root package name */
        private AbortIncompleteMultipartUpload f18950g;

        /* renamed from: h, reason: collision with root package name */
        private LifecycleFilter f18951h;

        /* renamed from: i, reason: collision with root package name */
        private List f18952i;

        /* renamed from: j, reason: collision with root package name */
        private String f18953j;

        /* renamed from: k, reason: collision with root package name */
        private String f18954k;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f18946c.getRules().add(this.f18947d);
                    this.f18947d = null;
                    return;
                }
                return;
            }
            if (e("LifecycleConfiguration", "Rule")) {
                if (str2.equals("ID")) {
                    this.f18947d.setId(d());
                    return;
                }
                if (str2.equals("Prefix")) {
                    this.f18947d.setPrefix(d());
                    return;
                }
                if (str2.equals("Status")) {
                    this.f18947d.setStatus(d());
                    return;
                }
                if (str2.equals("Transition")) {
                    this.f18947d.addTransition(this.f18948e);
                    this.f18948e = null;
                    return;
                }
                if (str2.equals("NoncurrentVersionTransition")) {
                    this.f18947d.addNoncurrentVersionTransition(this.f18949f);
                    this.f18949f = null;
                    return;
                } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                    this.f18947d.setAbortIncompleteMultipartUpload(this.f18950g);
                    this.f18950g = null;
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.f18947d.setFilter(this.f18951h);
                        this.f18951h = null;
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Expiration")) {
                if (str2.equals(HttpHeaders.DATE)) {
                    this.f18947d.setExpirationDate(ServiceUtils.d(d()));
                    return;
                }
                if (str2.equals("Days")) {
                    this.f18947d.setExpirationInDays(Integer.parseInt(d()));
                    return;
                } else {
                    if (str2.equals("ExpiredObjectDeleteMarker") && "true".equals(d())) {
                        this.f18947d.setExpiredObjectDeleteMarker(true);
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Transition")) {
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f18948e.setStorageClass(d());
                    return;
                } else if (str2.equals(HttpHeaders.DATE)) {
                    this.f18948e.setDate(ServiceUtils.d(d()));
                    return;
                } else {
                    if (str2.equals("Days")) {
                        this.f18948e.setDays(Integer.parseInt(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "NoncurrentVersionExpiration")) {
                if (str2.equals("NoncurrentDays")) {
                    this.f18947d.setNoncurrentVersionExpirationInDays(Integer.parseInt(d()));
                    return;
                }
                return;
            }
            if (e("LifecycleConfiguration", "Rule", "NoncurrentVersionTransition")) {
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f18949f.setStorageClass(d());
                    return;
                } else {
                    if (str2.equals("NoncurrentDays")) {
                        this.f18949f.setDays(Integer.parseInt(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "AbortIncompleteMultipartUpload")) {
                if (str2.equals("DaysAfterInitiation")) {
                    this.f18950g.setDaysAfterInitiation(Integer.parseInt(d()));
                    return;
                }
                return;
            }
            if (e("LifecycleConfiguration", "Rule", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f18951h.setPredicate(new LifecyclePrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f18951h.setPredicate(new LifecycleTagPredicate(new Tag(this.f18953j, this.f18954k)));
                    this.f18953j = null;
                    this.f18954k = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f18951h.setPredicate(new LifecycleAndOperator(this.f18952i));
                        this.f18952i = null;
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f18953j = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f18954k = d();
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f18952i.add(new LifecyclePrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f18952i.add(new LifecycleTagPredicate(new Tag(this.f18953j, this.f18954k)));
                        this.f18953j = null;
                        this.f18954k = null;
                        return;
                    }
                    return;
                }
            }
            if (e("LifecycleConfiguration", "Rule", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f18953j = d();
                } else if (str2.equals("Value")) {
                    this.f18954k = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f18947d = new BucketLifecycleConfiguration.Rule();
                    return;
                }
                return;
            }
            if (!e("LifecycleConfiguration", "Rule")) {
                if (e("LifecycleConfiguration", "Rule", "Filter") && str2.equals("And")) {
                    this.f18952i = new ArrayList();
                    return;
                }
                return;
            }
            if (str2.equals("Transition")) {
                this.f18948e = new BucketLifecycleConfiguration.Transition();
                return;
            }
            if (str2.equals("NoncurrentVersionTransition")) {
                this.f18949f = new BucketLifecycleConfiguration.NoncurrentVersionTransition();
            } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                this.f18950g = new AbortIncompleteMultipartUpload();
            } else if (str2.equals("Filter")) {
                this.f18951h = new LifecycleFilter();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketLocationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private String f18955c = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (a() && str2.equals(CreateBucketRequest.TAB_LOCATIONCONSTRAINT)) {
                String d11 = d();
                if (d11.length() == 0) {
                    this.f18955c = null;
                } else {
                    this.f18955c = d11;
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketLoggingConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final BucketLoggingConfiguration f18956c = new BucketLoggingConfiguration();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("BucketLoggingStatus", "LoggingEnabled")) {
                if (str2.equals("TargetBucket")) {
                    this.f18956c.setDestinationBucketName(d());
                } else if (str2.equals("TargetPrefix")) {
                    this.f18956c.setLogFilePrefix(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketReplicationConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final BucketReplicationConfiguration f18957c = new BucketReplicationConfiguration();

        /* renamed from: d, reason: collision with root package name */
        private String f18958d;

        /* renamed from: e, reason: collision with root package name */
        private ReplicationRule f18959e;

        /* renamed from: f, reason: collision with root package name */
        private ReplicationDestinationConfig f18960f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("ReplicationConfiguration")) {
                if (!str2.equals("Rule")) {
                    if (str2.equals("Role")) {
                        this.f18957c.setRoleARN(d());
                        return;
                    }
                    return;
                } else {
                    this.f18957c.addRule(this.f18958d, this.f18959e);
                    this.f18959e = null;
                    this.f18958d = null;
                    this.f18960f = null;
                    return;
                }
            }
            if (!e("ReplicationConfiguration", "Rule")) {
                if (e("ReplicationConfiguration", "Rule", "Destination")) {
                    if (str2.equals("Bucket")) {
                        this.f18960f.a(d());
                        return;
                    } else {
                        if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                            this.f18960f.b(d());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("ID")) {
                this.f18958d = d();
                return;
            }
            if (str2.equals("Prefix")) {
                this.f18959e.b(d());
            } else if (str2.equals("Status")) {
                this.f18959e.c(d());
            } else if (str2.equals("Destination")) {
                this.f18959e.a(this.f18960f);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ReplicationConfiguration")) {
                if (str2.equals("Rule")) {
                    this.f18959e = new ReplicationRule();
                }
            } else if (e("ReplicationConfiguration", "Rule") && str2.equals("Destination")) {
                this.f18960f = new ReplicationDestinationConfig();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketTaggingConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final BucketTaggingConfiguration f18961c = new BucketTaggingConfiguration();

        /* renamed from: d, reason: collision with root package name */
        private Map f18962d;

        /* renamed from: e, reason: collision with root package name */
        private String f18963e;

        /* renamed from: f, reason: collision with root package name */
        private String f18964f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            String str4;
            if (e("Tagging")) {
                if (str2.equals("TagSet")) {
                    this.f18961c.getAllTagSets().add(new TagSet(this.f18962d));
                    this.f18962d = null;
                    return;
                }
                return;
            }
            if (e("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    String str5 = this.f18963e;
                    if (str5 != null && (str4 = this.f18964f) != null) {
                        this.f18962d.put(str5, str4);
                    }
                    this.f18963e = null;
                    this.f18964f = null;
                    return;
                }
                return;
            }
            if (e("Tagging", "TagSet", "Tag")) {
                if (str2.equals("Key")) {
                    this.f18963e = d();
                } else if (str2.equals("Value")) {
                    this.f18964f = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f18962d = new HashMap();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketVersioningConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final BucketVersioningConfiguration f18965c = new BucketVersioningConfiguration();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("VersioningConfiguration")) {
                if (str2.equals("Status")) {
                    this.f18965c.setStatus(d());
                    return;
                }
                if (str2.equals("MfaDelete")) {
                    String d11 = d();
                    if (d11.equals(BucketLifecycleConfiguration.DISABLED)) {
                        this.f18965c.setMfaDeleteEnabled(Boolean.FALSE);
                    } else if (d11.equals("Enabled")) {
                        this.f18965c.setMfaDeleteEnabled(Boolean.TRUE);
                    } else {
                        this.f18965c.setMfaDeleteEnabled(null);
                    }
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    /* loaded from: classes2.dex */
    public static class BucketWebsiteConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final BucketWebsiteConfiguration f18966c = new BucketWebsiteConfiguration(null);

        /* renamed from: d, reason: collision with root package name */
        private RoutingRuleCondition f18967d = null;

        /* renamed from: e, reason: collision with root package name */
        private RedirectRule f18968e = null;

        /* renamed from: f, reason: collision with root package name */
        private RoutingRule f18969f = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.f18966c.setRedirectAllRequestsTo(this.f18968e);
                    this.f18968e = null;
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "IndexDocument")) {
                if (str2.equals("Suffix")) {
                    this.f18966c.setIndexDocumentSuffix(d());
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "ErrorDocument")) {
                if (str2.equals("Key")) {
                    this.f18966c.setErrorDocument(d());
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.f18966c.getRoutingRules().add(this.f18969f);
                    this.f18969f = null;
                    return;
                }
                return;
            }
            if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.f18969f.a(this.f18967d);
                    this.f18967d = null;
                    return;
                } else {
                    if (str2.equals("Redirect")) {
                        this.f18969f.b(this.f18968e);
                        this.f18968e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Condition")) {
                if (str2.equals("KeyPrefixEquals")) {
                    this.f18967d.b(d());
                    return;
                } else {
                    if (str2.equals("HttpErrorCodeReturnedEquals")) {
                        this.f18967d.a(d());
                        return;
                    }
                    return;
                }
            }
            if (e("WebsiteConfiguration", "RedirectAllRequestsTo") || e("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Redirect")) {
                if (str2.equals("Protocol")) {
                    this.f18968e.c(d());
                    return;
                }
                if (str2.equals("HostName")) {
                    this.f18968e.a(d());
                    return;
                }
                if (str2.equals("ReplaceKeyPrefixWith")) {
                    this.f18968e.d(d());
                } else if (str2.equals("ReplaceKeyWith")) {
                    this.f18968e.e(d());
                } else if (str2.equals("HttpRedirectCode")) {
                    this.f18968e.b(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.f18968e = new RedirectRule();
                }
            } else if (e("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.f18969f = new RoutingRule();
                }
            } else if (e("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.f18967d = new RoutingRuleCondition();
                } else if (str2.equals("Redirect")) {
                    this.f18968e = new RedirectRule();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class CompleteMultipartUploadHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3VersionResult, S3RequesterChargedResult {

        /* renamed from: c, reason: collision with root package name */
        private CompleteMultipartUploadResult f18970c;

        /* renamed from: d, reason: collision with root package name */
        private AmazonS3Exception f18971d;

        /* renamed from: e, reason: collision with root package name */
        private String f18972e;

        /* renamed from: f, reason: collision with root package name */
        private String f18973f;

        /* renamed from: g, reason: collision with root package name */
        private String f18974g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            AmazonS3Exception amazonS3Exception;
            if (a()) {
                if (!str2.equals("Error") || (amazonS3Exception = this.f18971d) == null) {
                    return;
                }
                amazonS3Exception.setErrorCode(this.f18974g);
                this.f18971d.setRequestId(this.f18973f);
                this.f18971d.setExtendedRequestId(this.f18972e);
                return;
            }
            if (e("CompleteMultipartUploadResult")) {
                if (str2.equals(HttpHeaders.LOCATION)) {
                    this.f18970c.setLocation(d());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.f18970c.setBucketName(d());
                    return;
                } else if (str2.equals("Key")) {
                    this.f18970c.setKey(d());
                    return;
                } else {
                    if (str2.equals("ETag")) {
                        this.f18970c.setETag(ServiceUtils.f(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("Error")) {
                if (str2.equals("Code")) {
                    this.f18974g = d();
                    return;
                }
                if (str2.equals("Message")) {
                    this.f18971d = new AmazonS3Exception(d());
                } else if (str2.equals("RequestId")) {
                    this.f18973f = d();
                } else if (str2.equals("HostId")) {
                    this.f18972e = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (a() && str2.equals("CompleteMultipartUploadResult")) {
                this.f18970c = new CompleteMultipartUploadResult();
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractSSEHandler
        protected ServerSideEncryptionResult f() {
            return this.f18970c;
        }

        public AmazonS3Exception g() {
            return this.f18971d;
        }

        public CompleteMultipartUploadResult h() {
            return this.f18970c;
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTime(Date date) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f18970c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTime(date);
            }
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTimeRuleId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f18970c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setExpirationTimeRuleId(str);
            }
        }

        @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
        public void setRequesterCharged(boolean z10) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f18970c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setRequesterCharged(z10);
            }
        }

        @Override // com.amazonaws.services.s3.internal.S3VersionResult
        public void setVersionId(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.f18970c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.setVersionId(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class CopyObjectResultHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {

        /* renamed from: c, reason: collision with root package name */
        private final CopyObjectResult f18975c = new CopyObjectResult();

        /* renamed from: d, reason: collision with root package name */
        private String f18976d = null;

        /* renamed from: e, reason: collision with root package name */
        private String f18977e = null;

        /* renamed from: f, reason: collision with root package name */
        private String f18978f = null;

        /* renamed from: g, reason: collision with root package name */
        private String f18979g = null;

        /* renamed from: h, reason: collision with root package name */
        private boolean f18980h = false;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("CopyObjectResult") || e("CopyPartResult")) {
                if (str2.equals("LastModified")) {
                    this.f18975c.setLastModifiedDate(ServiceUtils.d(d()));
                    return;
                } else {
                    if (str2.equals("ETag")) {
                        this.f18975c.setETag(ServiceUtils.f(d()));
                        return;
                    }
                    return;
                }
            }
            if (e("Error")) {
                if (str2.equals("Code")) {
                    this.f18976d = d();
                    return;
                }
                if (str2.equals("Message")) {
                    this.f18977e = d();
                } else if (str2.equals("RequestId")) {
                    this.f18978f = d();
                } else if (str2.equals("HostId")) {
                    this.f18979g = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (a()) {
                if (str2.equals("CopyObjectResult") || str2.equals("CopyPartResult")) {
                    this.f18980h = false;
                } else if (str2.equals("Error")) {
                    this.f18980h = true;
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractSSEHandler
        protected ServerSideEncryptionResult f() {
            return this.f18975c;
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTime(Date date) {
            this.f18975c.setExpirationTime(date);
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void setExpirationTimeRuleId(String str) {
            this.f18975c.setExpirationTimeRuleId(str);
        }

        @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
        public void setRequesterCharged(boolean z10) {
            this.f18975c.setRequesterCharged(z10);
        }

        @Override // com.amazonaws.services.s3.internal.S3VersionResult
        public void setVersionId(String str) {
            this.f18975c.setVersionId(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class DeleteObjectsHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final DeleteObjectsResponse f18981c = new DeleteObjectsResponse();

        /* renamed from: d, reason: collision with root package name */
        private DeleteObjectsResult.DeletedObject f18982d = null;

        /* renamed from: e, reason: collision with root package name */
        private MultiObjectDeleteException.DeleteError f18983e = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.f18981c.a().add(this.f18982d);
                    this.f18982d = null;
                    return;
                } else {
                    if (str2.equals("Error")) {
                        this.f18981c.b().add(this.f18983e);
                        this.f18983e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("DeleteResult", "Deleted")) {
                if (str2.equals("Key")) {
                    this.f18982d.setKey(d());
                    return;
                }
                if (str2.equals("VersionId")) {
                    this.f18982d.setVersionId(d());
                    return;
                } else if (str2.equals("DeleteMarker")) {
                    this.f18982d.setDeleteMarker(d().equals("true"));
                    return;
                } else {
                    if (str2.equals("DeleteMarkerVersionId")) {
                        this.f18982d.setDeleteMarkerVersionId(d());
                        return;
                    }
                    return;
                }
            }
            if (e("DeleteResult", "Error")) {
                if (str2.equals("Key")) {
                    this.f18983e.b(d());
                    return;
                }
                if (str2.equals("VersionId")) {
                    this.f18983e.d(d());
                } else if (str2.equals("Code")) {
                    this.f18983e.a(d());
                } else if (str2.equals("Message")) {
                    this.f18983e.c(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.f18982d = new DeleteObjectsResult.DeletedObject();
                } else if (str2.equals("Error")) {
                    this.f18983e = new MultiObjectDeleteException.DeleteError();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class GetBucketAnalyticsConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final AnalyticsConfiguration f18984c = new AnalyticsConfiguration();

        /* renamed from: d, reason: collision with root package name */
        private AnalyticsFilter f18985d;

        /* renamed from: e, reason: collision with root package name */
        private List f18986e;

        /* renamed from: f, reason: collision with root package name */
        private StorageClassAnalysis f18987f;

        /* renamed from: g, reason: collision with root package name */
        private StorageClassAnalysisDataExport f18988g;

        /* renamed from: h, reason: collision with root package name */
        private AnalyticsExportDestination f18989h;

        /* renamed from: i, reason: collision with root package name */
        private AnalyticsS3BucketDestination f18990i;

        /* renamed from: j, reason: collision with root package name */
        private String f18991j;

        /* renamed from: k, reason: collision with root package name */
        private String f18992k;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f18984c.setId(d());
                    return;
                } else if (str2.equals("Filter")) {
                    this.f18984c.setFilter(this.f18985d);
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f18984c.setStorageClassAnalysis(this.f18987f);
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f18985d.setPredicate(new AnalyticsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f18985d.setPredicate(new AnalyticsTagPredicate(new Tag(this.f18991j, this.f18992k)));
                    this.f18991j = null;
                    this.f18992k = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f18985d.setPredicate(new AnalyticsAndOperator(this.f18986e));
                        this.f18986e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f18991j = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f18992k = d();
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f18986e.add(new AnalyticsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f18986e.add(new AnalyticsTagPredicate(new Tag(this.f18991j, this.f18992k)));
                        this.f18991j = null;
                        this.f18992k = null;
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f18991j = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f18992k = d();
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f18987f.setDataExport(this.f18988g);
                    return;
                }
                return;
            }
            if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.f18988g.setOutputSchemaVersion(d());
                    return;
                } else {
                    if (str2.equals("Destination")) {
                        this.f18988g.setDestination(this.f18989h);
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f18989h.setS3BucketDestination(this.f18990i);
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
                if (str2.equals("Format")) {
                    this.f18990i.setFormat(d());
                    return;
                }
                if (str2.equals("BucketAccountId")) {
                    this.f18990i.setBucketAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f18990i.setBucketArn(d());
                } else if (str2.equals("Prefix")) {
                    this.f18990i.setPrefix(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f18985d = new AnalyticsFilter();
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f18987f = new StorageClassAnalysis();
                        return;
                    }
                    return;
                }
            }
            if (e("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.f18986e = new ArrayList();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f18988g = new StorageClassAnalysisDataExport();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.f18989h = new AnalyticsExportDestination();
                }
            } else if (e("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.f18990i = new AnalyticsS3BucketDestination();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class GetBucketInventoryConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final GetBucketInventoryConfigurationResult f18993c = new GetBucketInventoryConfigurationResult();

        /* renamed from: d, reason: collision with root package name */
        private final InventoryConfiguration f18994d = new InventoryConfiguration();

        /* renamed from: e, reason: collision with root package name */
        private List f18995e;

        /* renamed from: f, reason: collision with root package name */
        private InventoryDestination f18996f;

        /* renamed from: g, reason: collision with root package name */
        private InventoryFilter f18997g;

        /* renamed from: h, reason: collision with root package name */
        private InventoryS3BucketDestination f18998h;

        /* renamed from: i, reason: collision with root package name */
        private InventorySchedule f18999i;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.f18994d.setId(d());
                    return;
                }
                if (str2.equals("Destination")) {
                    this.f18994d.setDestination(this.f18996f);
                    this.f18996f = null;
                    return;
                }
                if (str2.equals("IsEnabled")) {
                    this.f18994d.setEnabled(Boolean.valueOf("true".equals(d())));
                    return;
                }
                if (str2.equals("Filter")) {
                    this.f18994d.setInventoryFilter(this.f18997g);
                    this.f18997g = null;
                    return;
                }
                if (str2.equals("IncludedObjectVersions")) {
                    this.f18994d.setIncludedObjectVersions(d());
                    return;
                }
                if (str2.equals("Schedule")) {
                    this.f18994d.setSchedule(this.f18999i);
                    this.f18999i = null;
                    return;
                } else {
                    if (str2.equals("OptionalFields")) {
                        this.f18994d.setOptionalFields(this.f18995e);
                        this.f18995e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f18996f.setS3BucketDestination(this.f18998h);
                    this.f18998h = null;
                    return;
                }
                return;
            }
            if (e("InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.f18998h.setAccountId(d());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.f18998h.setBucketArn(d());
                    return;
                } else if (str2.equals("Format")) {
                    this.f18998h.setFormat(d());
                    return;
                } else {
                    if (str2.equals("Prefix")) {
                        this.f18998h.setPrefix(d());
                        return;
                    }
                    return;
                }
            }
            if (e("InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f18997g.setPredicate(new InventoryPrefixPredicate(d()));
                }
            } else if (e("InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.f18999i.setFrequency(d());
                }
            } else if (e("InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.f18995e.add(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("InventoryConfiguration")) {
                if (e("InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                    this.f18998h = new InventoryS3BucketDestination();
                    return;
                }
                return;
            }
            if (str2.equals("Destination")) {
                this.f18996f = new InventoryDestination();
                return;
            }
            if (str2.equals("Filter")) {
                this.f18997g = new InventoryFilter();
            } else if (str2.equals("Schedule")) {
                this.f18999i = new InventorySchedule();
            } else if (str2.equals("OptionalFields")) {
                this.f18995e = new ArrayList();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class GetBucketMetricsConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final MetricsConfiguration f19000c = new MetricsConfiguration();

        /* renamed from: d, reason: collision with root package name */
        private MetricsFilter f19001d;

        /* renamed from: e, reason: collision with root package name */
        private List f19002e;

        /* renamed from: f, reason: collision with root package name */
        private String f19003f;

        /* renamed from: g, reason: collision with root package name */
        private String f19004g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f19000c.setId(d());
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.f19000c.setFilter(this.f19001d);
                        this.f19001d = null;
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f19001d.setPredicate(new MetricsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f19001d.setPredicate(new MetricsTagPredicate(new Tag(this.f19003f, this.f19004g)));
                    this.f19003f = null;
                    this.f19004g = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f19001d.setPredicate(new MetricsAndOperator(this.f19002e));
                        this.f19002e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f19003f = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f19004g = d();
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f19002e.add(new MetricsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f19002e.add(new MetricsTagPredicate(new Tag(this.f19003f, this.f19004g)));
                        this.f19003f = null;
                        this.f19004g = null;
                        return;
                    }
                    return;
                }
            }
            if (e("MetricsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f19003f = d();
                } else if (str2.equals("Value")) {
                    this.f19004g = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f19001d = new MetricsFilter();
                }
            } else if (e("MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.f19002e = new ArrayList();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class GetObjectTaggingHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private GetObjectTaggingResult f19005c;

        /* renamed from: d, reason: collision with root package name */
        private List f19006d;

        /* renamed from: e, reason: collision with root package name */
        private String f19007e;

        /* renamed from: f, reason: collision with root package name */
        private String f19008f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f19005c = new GetObjectTaggingResult(this.f19006d);
                this.f19006d = null;
            }
            if (e("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    this.f19006d.add(new Tag(this.f19008f, this.f19007e));
                    this.f19008f = null;
                    this.f19007e = null;
                    return;
                }
                return;
            }
            if (e("Tagging", "TagSet", "Tag")) {
                if (str2.equals("Key")) {
                    this.f19008f = d();
                } else if (str2.equals("Value")) {
                    this.f19007e = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("Tagging") && str2.equals("TagSet")) {
                this.f19006d = new ArrayList();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class InitiateMultipartUploadHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final InitiateMultipartUploadResult f19009c = new InitiateMultipartUploadResult();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("InitiateMultipartUploadResult")) {
                if (str2.equals("Bucket")) {
                    this.f19009c.setBucketName(d());
                } else if (str2.equals("Key")) {
                    this.f19009c.setKey(d());
                } else if (str2.equals("UploadId")) {
                    this.f19009c.b(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
        }

        public InitiateMultipartUploadResult f() {
            return this.f19009c;
        }
    }

    /* loaded from: classes2.dex */
    public static class ListAllMyBucketsHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final List f19010c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private Owner f19011d = null;

        /* renamed from: e, reason: collision with root package name */
        private Bucket f19012e = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("ListAllMyBucketsResult", "Owner")) {
                if (str2.equals("ID")) {
                    this.f19011d.setId(d());
                    return;
                } else {
                    if (str2.equals("DisplayName")) {
                        this.f19011d.setDisplayName(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListAllMyBucketsResult", "Buckets")) {
                if (str2.equals("Bucket")) {
                    this.f19010c.add(this.f19012e);
                    this.f19012e = null;
                    return;
                }
                return;
            }
            if (e("ListAllMyBucketsResult", "Buckets", "Bucket")) {
                if (str2.equals("Name")) {
                    this.f19012e.setName(d());
                } else if (str2.equals("CreationDate")) {
                    this.f19012e.setCreationDate(DateUtils.h(d()));
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListAllMyBucketsResult")) {
                if (str2.equals("Owner")) {
                    this.f19011d = new Owner();
                }
            } else if (e("ListAllMyBucketsResult", "Buckets") && str2.equals("Bucket")) {
                Bucket bucket = new Bucket();
                this.f19012e = bucket;
                bucket.setOwner(this.f19011d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListBucketAnalyticsConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final ListBucketAnalyticsConfigurationsResult f19013c = new ListBucketAnalyticsConfigurationsResult();

        /* renamed from: d, reason: collision with root package name */
        private AnalyticsConfiguration f19014d;

        /* renamed from: e, reason: collision with root package name */
        private AnalyticsFilter f19015e;

        /* renamed from: f, reason: collision with root package name */
        private List f19016f;

        /* renamed from: g, reason: collision with root package name */
        private StorageClassAnalysis f19017g;

        /* renamed from: h, reason: collision with root package name */
        private StorageClassAnalysisDataExport f19018h;

        /* renamed from: i, reason: collision with root package name */
        private AnalyticsExportDestination f19019i;

        /* renamed from: j, reason: collision with root package name */
        private AnalyticsS3BucketDestination f19020j;

        /* renamed from: k, reason: collision with root package name */
        private String f19021k;

        /* renamed from: l, reason: collision with root package name */
        private String f19022l;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    if (this.f19013c.getAnalyticsConfigurationList() == null) {
                        this.f19013c.setAnalyticsConfigurationList(new ArrayList());
                    }
                    this.f19013c.getAnalyticsConfigurationList().add(this.f19014d);
                    this.f19014d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f19013c.setTruncated("true".equals(d()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.f19013c.setContinuationToken(d());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.f19013c.setNextContinuationToken(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f19014d.setId(d());
                    return;
                } else if (str2.equals("Filter")) {
                    this.f19014d.setFilter(this.f19015e);
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f19014d.setStorageClassAnalysis(this.f19017g);
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f19015e.setPredicate(new AnalyticsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f19015e.setPredicate(new AnalyticsTagPredicate(new Tag(this.f19021k, this.f19022l)));
                    this.f19021k = null;
                    this.f19022l = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f19015e.setPredicate(new AnalyticsAndOperator(this.f19016f));
                        this.f19016f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f19021k = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f19022l = d();
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f19016f.add(new AnalyticsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f19016f.add(new AnalyticsTagPredicate(new Tag(this.f19021k, this.f19022l)));
                        this.f19021k = null;
                        this.f19022l = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f19021k = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f19022l = d();
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f19017g.setDataExport(this.f19018h);
                    return;
                }
                return;
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.f19018h.setOutputSchemaVersion(d());
                    return;
                } else {
                    if (str2.equals("Destination")) {
                        this.f19018h.setDestination(this.f19019i);
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f19019i.setS3BucketDestination(this.f19020j);
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
                if (str2.equals("Format")) {
                    this.f19020j.setFormat(d());
                    return;
                }
                if (str2.equals("BucketAccountId")) {
                    this.f19020j.setBucketAccountId(d());
                } else if (str2.equals("Bucket")) {
                    this.f19020j.setBucketArn(d());
                } else if (str2.equals("Prefix")) {
                    this.f19020j.setPrefix(d());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    this.f19014d = new AnalyticsConfiguration();
                    return;
                }
                return;
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f19015e = new AnalyticsFilter();
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f19017g = new StorageClassAnalysis();
                        return;
                    }
                    return;
                }
            }
            if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.f19016f = new ArrayList();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f19018h = new StorageClassAnalysisDataExport();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.f19019i = new AnalyticsExportDestination();
                }
            } else if (e("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.f19020j = new AnalyticsS3BucketDestination();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListBucketHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final ObjectListing f19023c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f19024d;

        /* renamed from: e, reason: collision with root package name */
        private S3ObjectSummary f19025e;

        /* renamed from: f, reason: collision with root package name */
        private Owner f19026f;

        /* renamed from: g, reason: collision with root package name */
        private String f19027g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            String str4 = null;
            if (a()) {
                if (str2.equals("ListBucketResult") && this.f19023c.isTruncated() && this.f19023c.getNextMarker() == null) {
                    if (!this.f19023c.getObjectSummaries().isEmpty()) {
                        str4 = this.f19023c.getObjectSummaries().get(this.f19023c.getObjectSummaries().size() - 1).a();
                    } else if (this.f19023c.getCommonPrefixes().isEmpty()) {
                        XmlResponsesSaxParser.f18933c.f("S3 response indicates truncated results, but contains no object summaries or common prefixes.");
                    } else {
                        str4 = this.f19023c.getCommonPrefixes().get(this.f19023c.getCommonPrefixes().size() - 1);
                    }
                    this.f19023c.setNextMarker(str4);
                    return;
                }
                return;
            }
            if (!e("ListBucketResult")) {
                if (!e("ListBucketResult", "Contents")) {
                    if (!e("ListBucketResult", "Contents", "Owner")) {
                        if (e("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                            this.f19023c.getCommonPrefixes().add(XmlResponsesSaxParser.h(d(), this.f19024d));
                            return;
                        }
                        return;
                    }
                    if (str2.equals("ID")) {
                        this.f19026f.setId(d());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f19026f.setDisplayName(d());
                            return;
                        }
                        return;
                    }
                }
                if (str2.equals("Key")) {
                    String d11 = d();
                    this.f19027g = d11;
                    this.f19025e.d(XmlResponsesSaxParser.h(d11, this.f19024d));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.f19025e.e(ServiceUtils.d(d()));
                    return;
                }
                if (str2.equals("ETag")) {
                    this.f19025e.c(ServiceUtils.f(d()));
                    return;
                }
                if (str2.equals("Size")) {
                    this.f19025e.g(XmlResponsesSaxParser.m(d()));
                    return;
                }
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f19025e.h(d());
                    return;
                } else {
                    if (str2.equals("Owner")) {
                        this.f19025e.f(this.f19026f);
                        this.f19026f = null;
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Name")) {
                this.f19023c.setBucketName(d());
                if (XmlResponsesSaxParser.f18933c.b()) {
                    XmlResponsesSaxParser.f18933c.a("Examining listing for bucket: " + this.f19023c.getBucketName());
                    return;
                }
                return;
            }
            if (str2.equals("Prefix")) {
                this.f19023c.setPrefix(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19024d));
                return;
            }
            if (str2.equals("Marker")) {
                this.f19023c.setMarker(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19024d));
                return;
            }
            if (str2.equals("NextMarker")) {
                this.f19023c.setNextMarker(XmlResponsesSaxParser.h(d(), this.f19024d));
                return;
            }
            if (str2.equals("MaxKeys")) {
                this.f19023c.setMaxKeys(XmlResponsesSaxParser.l(d()));
                return;
            }
            if (str2.equals("Delimiter")) {
                this.f19023c.setDelimiter(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19024d));
                return;
            }
            if (str2.equals("EncodingType")) {
                this.f19023c.setEncodingType(XmlResponsesSaxParser.g(d()));
                return;
            }
            if (!str2.equals("IsTruncated")) {
                if (str2.equals("Contents")) {
                    this.f19023c.getObjectSummaries().add(this.f19025e);
                    this.f19025e = null;
                    return;
                }
                return;
            }
            String b11 = StringUtils.b(d());
            if (b11.startsWith("false")) {
                this.f19023c.setTruncated(false);
            } else {
                if (b11.startsWith("true")) {
                    this.f19023c.setTruncated(true);
                    return;
                }
                throw new IllegalStateException("Invalid value for IsTruncated field: " + b11);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("ListBucketResult")) {
                if (e("ListBucketResult", "Contents") && str2.equals("Owner")) {
                    this.f19026f = new Owner();
                    return;
                }
                return;
            }
            if (str2.equals("Contents")) {
                S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                this.f19025e = s3ObjectSummary;
                s3ObjectSummary.b(this.f19023c.getBucketName());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListBucketInventoryConfigurationsHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final ListBucketInventoryConfigurationsResult f19028c = new ListBucketInventoryConfigurationsResult();

        /* renamed from: d, reason: collision with root package name */
        private InventoryConfiguration f19029d;

        /* renamed from: e, reason: collision with root package name */
        private List f19030e;

        /* renamed from: f, reason: collision with root package name */
        private InventoryDestination f19031f;

        /* renamed from: g, reason: collision with root package name */
        private InventoryFilter f19032g;

        /* renamed from: h, reason: collision with root package name */
        private InventoryS3BucketDestination f19033h;

        /* renamed from: i, reason: collision with root package name */
        private InventorySchedule f19034i;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    if (this.f19028c.getInventoryConfigurationList() == null) {
                        this.f19028c.setInventoryConfigurationList(new ArrayList());
                    }
                    this.f19028c.getInventoryConfigurationList().add(this.f19029d);
                    this.f19029d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f19028c.setTruncated("true".equals(d()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.f19028c.setContinuationToken(d());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.f19028c.setNextContinuationToken(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.f19029d.setId(d());
                    return;
                }
                if (str2.equals("Destination")) {
                    this.f19029d.setDestination(this.f19031f);
                    this.f19031f = null;
                    return;
                }
                if (str2.equals("IsEnabled")) {
                    this.f19029d.setEnabled(Boolean.valueOf("true".equals(d())));
                    return;
                }
                if (str2.equals("Filter")) {
                    this.f19029d.setInventoryFilter(this.f19032g);
                    this.f19032g = null;
                    return;
                }
                if (str2.equals("IncludedObjectVersions")) {
                    this.f19029d.setIncludedObjectVersions(d());
                    return;
                }
                if (str2.equals("Schedule")) {
                    this.f19029d.setSchedule(this.f19034i);
                    this.f19034i = null;
                    return;
                } else {
                    if (str2.equals("OptionalFields")) {
                        this.f19029d.setOptionalFields(this.f19030e);
                        this.f19030e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f19031f.setS3BucketDestination(this.f19033h);
                    this.f19033h = null;
                    return;
                }
                return;
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.f19033h.setAccountId(d());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.f19033h.setBucketArn(d());
                    return;
                } else if (str2.equals("Format")) {
                    this.f19033h.setFormat(d());
                    return;
                } else {
                    if (str2.equals("Prefix")) {
                        this.f19033h.setPrefix(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f19032g.setPredicate(new InventoryPrefixPredicate(d()));
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.f19034i.setFrequency(d());
                }
            } else if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.f19030e.add(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    this.f19029d = new InventoryConfiguration();
                    return;
                }
                return;
            }
            if (!e("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (e("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                    this.f19033h = new InventoryS3BucketDestination();
                    return;
                }
                return;
            }
            if (str2.equals("Destination")) {
                this.f19031f = new InventoryDestination();
                return;
            }
            if (str2.equals("Filter")) {
                this.f19032g = new InventoryFilter();
            } else if (str2.equals("Schedule")) {
                this.f19034i = new InventorySchedule();
            } else if (str2.equals("OptionalFields")) {
                this.f19030e = new ArrayList();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListBucketMetricsConfigurationsHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final ListBucketMetricsConfigurationsResult f19035c = new ListBucketMetricsConfigurationsResult();

        /* renamed from: d, reason: collision with root package name */
        private MetricsConfiguration f19036d;

        /* renamed from: e, reason: collision with root package name */
        private MetricsFilter f19037e;

        /* renamed from: f, reason: collision with root package name */
        private List f19038f;

        /* renamed from: g, reason: collision with root package name */
        private String f19039g;

        /* renamed from: h, reason: collision with root package name */
        private String f19040h;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    if (this.f19035c.getMetricsConfigurationList() == null) {
                        this.f19035c.setMetricsConfigurationList(new ArrayList());
                    }
                    this.f19035c.getMetricsConfigurationList().add(this.f19036d);
                    this.f19036d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f19035c.setTruncated("true".equals(d()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.f19035c.setContinuationToken(d());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.f19035c.setNextContinuationToken(d());
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.f19036d.setId(d());
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.f19036d.setFilter(this.f19037e);
                        this.f19037e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f19037e.setPredicate(new MetricsPrefixPredicate(d()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.f19037e.setPredicate(new MetricsTagPredicate(new Tag(this.f19039g, this.f19040h)));
                    this.f19039g = null;
                    this.f19040h = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.f19037e.setPredicate(new MetricsAndOperator(this.f19038f));
                        this.f19038f = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f19039g = d();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.f19040h = d();
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f19038f.add(new MetricsPrefixPredicate(d()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f19038f.add(new MetricsTagPredicate(new Tag(this.f19039g, this.f19040h)));
                        this.f19039g = null;
                        this.f19040h = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f19039g = d();
                } else if (str2.equals("Value")) {
                    this.f19040h = d();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    this.f19036d = new MetricsConfiguration();
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.f19037e = new MetricsFilter();
                }
            } else if (e("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.f19038f = new ArrayList();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListMultipartUploadsHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final MultipartUploadListing f19041c = new MultipartUploadListing();

        /* renamed from: d, reason: collision with root package name */
        private MultipartUpload f19042d;

        /* renamed from: e, reason: collision with root package name */
        private Owner f19043e;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("ListMultipartUploadsResult")) {
                if (str2.equals("Bucket")) {
                    this.f19041c.c(d());
                    return;
                }
                if (str2.equals("KeyMarker")) {
                    this.f19041c.f(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("Delimiter")) {
                    this.f19041c.d(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("Prefix")) {
                    this.f19041c.j(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("UploadIdMarker")) {
                    this.f19041c.l(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("NextKeyMarker")) {
                    this.f19041c.h(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("NextUploadIdMarker")) {
                    this.f19041c.i(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("MaxUploads")) {
                    this.f19041c.g(Integer.parseInt(d()));
                    return;
                }
                if (str2.equals("EncodingType")) {
                    this.f19041c.e(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f19041c.k(Boolean.parseBoolean(d()));
                    return;
                } else {
                    if (str2.equals("Upload")) {
                        this.f19041c.b().add(this.f19042d);
                        this.f19042d = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListMultipartUploadsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    this.f19041c.a().add(d());
                    return;
                }
                return;
            }
            if (!e("ListMultipartUploadsResult", "Upload")) {
                if (e("ListMultipartUploadsResult", "Upload", "Owner") || e("ListMultipartUploadsResult", "Upload", "Initiator")) {
                    if (str2.equals("ID")) {
                        this.f19043e.setId(XmlResponsesSaxParser.g(d()));
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f19043e.setDisplayName(XmlResponsesSaxParser.g(d()));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("Key")) {
                this.f19042d.c(d());
                return;
            }
            if (str2.equals("UploadId")) {
                this.f19042d.f(d());
                return;
            }
            if (str2.equals("Owner")) {
                this.f19042d.d(this.f19043e);
                this.f19043e = null;
            } else if (str2.equals("Initiator")) {
                this.f19042d.b(this.f19043e);
                this.f19043e = null;
            } else if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                this.f19042d.e(d());
            } else if (str2.equals("Initiated")) {
                this.f19042d.a(ServiceUtils.d(d()));
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListMultipartUploadsResult")) {
                if (str2.equals("Upload")) {
                    this.f19042d = new MultipartUpload();
                }
            } else if (e("ListMultipartUploadsResult", "Upload")) {
                if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.f19043e = new Owner();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListObjectsV2Handler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final ListObjectsV2Result f19044c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f19045d;

        /* renamed from: e, reason: collision with root package name */
        private S3ObjectSummary f19046e;

        /* renamed from: f, reason: collision with root package name */
        private Owner f19047f;

        /* renamed from: g, reason: collision with root package name */
        private String f19048g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            String str4 = null;
            if (a()) {
                if (str2.equals("ListBucketResult") && this.f19044c.e() && this.f19044c.c() == null) {
                    if (this.f19044c.d().isEmpty()) {
                        XmlResponsesSaxParser.f18933c.f("S3 response indicates truncated results, but contains no object summaries.");
                    } else {
                        str4 = ((S3ObjectSummary) this.f19044c.d().get(this.f19044c.d().size() - 1)).a();
                    }
                    this.f19044c.l(str4);
                    return;
                }
                return;
            }
            if (!e("ListBucketResult")) {
                if (!e("ListBucketResult", "Contents")) {
                    if (!e("ListBucketResult", "Contents", "Owner")) {
                        if (e("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                            this.f19044c.b().add(XmlResponsesSaxParser.h(d(), this.f19045d));
                            return;
                        }
                        return;
                    }
                    if (str2.equals("ID")) {
                        this.f19047f.setId(d());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f19047f.setDisplayName(d());
                            return;
                        }
                        return;
                    }
                }
                if (str2.equals("Key")) {
                    String d11 = d();
                    this.f19048g = d11;
                    this.f19046e.d(XmlResponsesSaxParser.h(d11, this.f19045d));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.f19046e.e(ServiceUtils.d(d()));
                    return;
                }
                if (str2.equals("ETag")) {
                    this.f19046e.c(ServiceUtils.f(d()));
                    return;
                }
                if (str2.equals("Size")) {
                    this.f19046e.g(XmlResponsesSaxParser.m(d()));
                    return;
                }
                if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                    this.f19046e.h(d());
                    return;
                } else {
                    if (str2.equals("Owner")) {
                        this.f19046e.f(this.f19047f);
                        this.f19047f = null;
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Name")) {
                this.f19044c.f(d());
                if (XmlResponsesSaxParser.f18933c.b()) {
                    XmlResponsesSaxParser.f18933c.a("Examining listing for bucket: " + this.f19044c.a());
                    return;
                }
                return;
            }
            if (str2.equals("Prefix")) {
                this.f19044c.m(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19045d));
                return;
            }
            if (str2.equals("MaxKeys")) {
                this.f19044c.k(XmlResponsesSaxParser.l(d()));
                return;
            }
            if (str2.equals("NextContinuationToken")) {
                this.f19044c.l(d());
                return;
            }
            if (str2.equals("ContinuationToken")) {
                this.f19044c.g(d());
                return;
            }
            if (str2.equals("StartAfter")) {
                this.f19044c.n(XmlResponsesSaxParser.h(d(), this.f19045d));
                return;
            }
            if (str2.equals("KeyCount")) {
                this.f19044c.j(XmlResponsesSaxParser.l(d()));
                return;
            }
            if (str2.equals("Delimiter")) {
                this.f19044c.h(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19045d));
                return;
            }
            if (str2.equals("EncodingType")) {
                this.f19044c.i(XmlResponsesSaxParser.g(d()));
                return;
            }
            if (!str2.equals("IsTruncated")) {
                if (str2.equals("Contents")) {
                    this.f19044c.d().add(this.f19046e);
                    this.f19046e = null;
                    return;
                }
                return;
            }
            String b11 = StringUtils.b(d());
            if (b11.startsWith("false")) {
                this.f19044c.o(false);
            } else {
                if (b11.startsWith("true")) {
                    this.f19044c.o(true);
                    return;
                }
                throw new IllegalStateException("Invalid value for IsTruncated field: " + b11);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("ListBucketResult")) {
                if (e("ListBucketResult", "Contents") && str2.equals("Owner")) {
                    this.f19047f = new Owner();
                    return;
                }
                return;
            }
            if (str2.equals("Contents")) {
                S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                this.f19046e = s3ObjectSummary;
                s3ObjectSummary.b(this.f19044c.a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListPartsHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final PartListing f19049c = new PartListing();

        /* renamed from: d, reason: collision with root package name */
        private PartSummary f19050d;

        /* renamed from: e, reason: collision with root package name */
        private Owner f19051e;

        private Integer f(String str) {
            String g11 = XmlResponsesSaxParser.g(d());
            if (g11 == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(g11));
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (!e("ListPartsResult")) {
                if (!e("ListPartsResult", "Part")) {
                    if (e("ListPartsResult", "Owner") || e("ListPartsResult", "Initiator")) {
                        if (str2.equals("ID")) {
                            this.f19051e.setId(XmlResponsesSaxParser.g(d()));
                            return;
                        } else {
                            if (str2.equals("DisplayName")) {
                                this.f19051e.setDisplayName(XmlResponsesSaxParser.g(d()));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (str2.equals("PartNumber")) {
                    this.f19050d.c(Integer.parseInt(d()));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.f19050d.b(ServiceUtils.d(d()));
                    return;
                } else if (str2.equals("ETag")) {
                    this.f19050d.a(ServiceUtils.f(d()));
                    return;
                } else {
                    if (str2.equals("Size")) {
                        this.f19050d.d(Long.parseLong(d()));
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Bucket")) {
                this.f19049c.b(d());
                return;
            }
            if (str2.equals("Key")) {
                this.f19049c.e(d());
                return;
            }
            if (str2.equals("UploadId")) {
                this.f19049c.l(d());
                return;
            }
            if (str2.equals("Owner")) {
                this.f19049c.h(this.f19051e);
                this.f19051e = null;
                return;
            }
            if (str2.equals("Initiator")) {
                this.f19049c.d(this.f19051e);
                this.f19051e = null;
                return;
            }
            if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                this.f19049c.j(d());
                return;
            }
            if (str2.equals("PartNumberMarker")) {
                this.f19049c.i(f(d()).intValue());
                return;
            }
            if (str2.equals("NextPartNumberMarker")) {
                this.f19049c.g(f(d()).intValue());
                return;
            }
            if (str2.equals("MaxParts")) {
                this.f19049c.f(f(d()).intValue());
                return;
            }
            if (str2.equals("EncodingType")) {
                this.f19049c.c(XmlResponsesSaxParser.g(d()));
                return;
            }
            if (str2.equals("IsTruncated")) {
                this.f19049c.k(Boolean.parseBoolean(d()));
            } else if (str2.equals("Part")) {
                this.f19049c.a().add(this.f19050d);
                this.f19050d = null;
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (e("ListPartsResult")) {
                if (str2.equals("Part")) {
                    this.f19050d = new PartSummary();
                } else if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.f19051e = new Owner();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListVersionsHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private final VersionListing f19052c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f19053d;

        /* renamed from: e, reason: collision with root package name */
        private S3VersionSummary f19054e;

        /* renamed from: f, reason: collision with root package name */
        private Owner f19055f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("ListVersionsResult")) {
                if (str2.equals("Name")) {
                    this.f19052c.j(d());
                    return;
                }
                if (str2.equals("Prefix")) {
                    this.f19052c.q(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19053d));
                    return;
                }
                if (str2.equals("KeyMarker")) {
                    this.f19052c.m(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19053d));
                    return;
                }
                if (str2.equals("VersionIdMarker")) {
                    this.f19052c.s(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("MaxKeys")) {
                    this.f19052c.n(Integer.parseInt(d()));
                    return;
                }
                if (str2.equals("Delimiter")) {
                    this.f19052c.k(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19053d));
                    return;
                }
                if (str2.equals("EncodingType")) {
                    this.f19052c.l(XmlResponsesSaxParser.g(d()));
                    return;
                }
                if (str2.equals("NextKeyMarker")) {
                    this.f19052c.o(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(d()), this.f19053d));
                    return;
                }
                if (str2.equals("NextVersionIdMarker")) {
                    this.f19052c.p(d());
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.f19052c.r("true".equals(d()));
                    return;
                } else {
                    if (str2.equals("Version") || str2.equals("DeleteMarker")) {
                        this.f19052c.i().add(this.f19054e);
                        this.f19054e = null;
                        return;
                    }
                    return;
                }
            }
            if (e("ListVersionsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    String g11 = XmlResponsesSaxParser.g(d());
                    List b11 = this.f19052c.b();
                    if (this.f19053d) {
                        g11 = S3HttpUtils.a(g11);
                    }
                    b11.add(g11);
                    return;
                }
                return;
            }
            if (!e("ListVersionsResult", "Version") && !e("ListVersionsResult", "DeleteMarker")) {
                if (e("ListVersionsResult", "Version", "Owner") || e("ListVersionsResult", "DeleteMarker", "Owner")) {
                    if (str2.equals("ID")) {
                        this.f19055f.setId(d());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f19055f.setDisplayName(d());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("Key")) {
                this.f19054e.e(XmlResponsesSaxParser.h(d(), this.f19053d));
                return;
            }
            if (str2.equals("VersionId")) {
                this.f19054e.j(d());
                return;
            }
            if (str2.equals("IsLatest")) {
                this.f19054e.d("true".equals(d()));
                return;
            }
            if (str2.equals("LastModified")) {
                this.f19054e.f(ServiceUtils.d(d()));
                return;
            }
            if (str2.equals("ETag")) {
                this.f19054e.b(ServiceUtils.f(d()));
                return;
            }
            if (str2.equals("Size")) {
                this.f19054e.h(Long.parseLong(d()));
                return;
            }
            if (str2.equals("Owner")) {
                this.f19054e.g(this.f19055f);
                this.f19055f = null;
            } else if (str2.equals(CreateBucketRequest.TAB_STORAGECLASS)) {
                this.f19054e.i(d());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
            if (!e("ListVersionsResult")) {
                if ((e("ListVersionsResult", "Version") || e("ListVersionsResult", "DeleteMarker")) && str2.equals("Owner")) {
                    this.f19055f = new Owner();
                    return;
                }
                return;
            }
            if (str2.equals("Version")) {
                S3VersionSummary s3VersionSummary = new S3VersionSummary();
                this.f19054e = s3VersionSummary;
                s3VersionSummary.a(this.f19052c.a());
            } else if (str2.equals("DeleteMarker")) {
                S3VersionSummary s3VersionSummary2 = new S3VersionSummary();
                this.f19054e = s3VersionSummary2;
                s3VersionSummary2.a(this.f19052c.a());
                this.f19054e.c(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class RequestPaymentConfigurationHandler extends AbstractHandler {

        /* renamed from: c, reason: collision with root package name */
        private String f19056c = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void b(String str, String str2, String str3) {
            if (e("RequestPaymentConfiguration") && str2.equals("Payer")) {
                this.f19056c = d();
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        protected void c(String str, String str2, String str3, Attributes attributes) {
        }
    }

    public XmlResponsesSaxParser() throws AmazonClientException {
        this.f18934a = null;
        try {
            this.f18934a = XMLReaderFactory.createXMLReader();
        } catch (SAXException e11) {
            System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            try {
                this.f18934a = XMLReaderFactory.createXMLReader();
            } catch (SAXException unused) {
                throw new AmazonClientException("Couldn't initialize a sax driver for the XMLReader", e11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(String str, boolean z10) {
        return z10 ? S3HttpUtils.a(str) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(String str, Attributes attributes) {
        if (!StringUtils.a(str) && attributes != null) {
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                if (attributes.getQName(i11).trim().equalsIgnoreCase(str.trim())) {
                    return attributes.getValue(i11);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            f18933c.e("Unable to parse integer value '" + str + "'", e11);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long m(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e11) {
            f18933c.e("Unable to parse long value '" + str + "'", e11);
            return -1L;
        }
    }

    public CompleteMultipartUploadHandler j(InputStream inputStream) {
        CompleteMultipartUploadHandler completeMultipartUploadHandler = new CompleteMultipartUploadHandler();
        n(completeMultipartUploadHandler, inputStream);
        return completeMultipartUploadHandler;
    }

    public InitiateMultipartUploadHandler k(InputStream inputStream) {
        InitiateMultipartUploadHandler initiateMultipartUploadHandler = new InitiateMultipartUploadHandler();
        n(initiateMultipartUploadHandler, inputStream);
        return initiateMultipartUploadHandler;
    }

    protected void n(DefaultHandler defaultHandler, InputStream inputStream) {
        try {
            Log log = f18933c;
            if (log.b()) {
                log.a("Parsing XML response document with handler: " + defaultHandler.getClass());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            this.f18934a.setContentHandler(defaultHandler);
            this.f18934a.setErrorHandler(defaultHandler);
            this.f18934a.parse(new InputSource(bufferedReader));
        } catch (IOException e11) {
            throw e11;
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e12) {
                if (f18933c.h()) {
                    f18933c.e("Unable to close response InputStream up after XML parse failure", e12);
                }
            }
            throw new AmazonClientException("Failed to parse XML document with handler " + defaultHandler.getClass(), th2);
        }
    }
}
