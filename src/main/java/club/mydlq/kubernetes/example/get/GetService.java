package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.*;

/**
 * - 描述：获取 Service
 * - API版本： v1
 */
public class GetService {

    /**
     * 获取全部 Namespace 的 Service 列表
     */
    public static void getAllService() throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 下的 Service 列表
        V1ServiceList serviceList = api.listServiceForAllNamespaces(null, null, null, null, null, null, null, null, null);
        for (V1Service item : serviceList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Service 列表
     */
    public static void getNamespaceServiceList(String namespace) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 的 Service 列表
        V1ServiceList serviceList = api.listNamespacedService(namespace, null, null, null, null, null, null, null, null,null);
        for (V1Service item : serviceList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Service
     */
    public static void getNamespaceService(String namespace, String serviceName) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 Service
        V1Service service = api.readNamespacedService(serviceName, namespace, null, null, null);
        System.out.println(service);
    }

    /**
     * 获取 Node
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取全部 Namespace 的 Service
        getAllService();
        // 获取某个 Namespace 的 Service 列表
        getNamespaceServiceList("kube-system");
        // 获取某个 Namespace 的某个 Service
        getNamespaceService("kube-system","kubelet");
    }

}
