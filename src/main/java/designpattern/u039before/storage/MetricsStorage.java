package designpattern.u039before.storage;

import designpattern.u039before.RequestInfo;
import java.util.List;
import java.util.Map;

/**
 * Created by HuGuodong on 1/31/20.
 */

public interface MetricsStorage {

  void saveRequestInfo(RequestInfo requestInfo);

  List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

  Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}


