package org.frameworkset.elasticsearch.client;

import org.apache.http.client.ResponseHandler;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.Client;
import org.frameworkset.elasticsearch.ElasticSearchEventSerializer;
import org.frameworkset.elasticsearch.ElasticSearchException;
import org.frameworkset.elasticsearch.EventDeliveryException;
import org.frameworkset.elasticsearch.IndexNameBuilder;
import org.frameworkset.elasticsearch.entity.*;
import org.frameworkset.elasticsearch.entity.suggest.CompleteRestResponse;
import org.frameworkset.elasticsearch.entity.suggest.PhraseRestResponse;
import org.frameworkset.elasticsearch.entity.suggest.TermRestResponse;
import org.frameworkset.elasticsearch.event.Event;
import org.frameworkset.elasticsearch.handler.ESAggBucketHandle;
import org.frameworkset.elasticsearch.scroll.ScrollHandler;
import org.frameworkset.elasticsearch.serial.ESTypeReferences;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TransportClientUtil  implements EventClientUtil{
	private ElasticSearchTransportClient client;
	 private BulkRequestBuilder bulkRequestBuilder;
	 private IndexNameBuilder indexNameBuilder;
	public TransportClientUtil(EventElasticSearchClient client,IndexNameBuilder indexNameBuilder) {
		this.client = (ElasticSearchTransportClient)client;
		this.indexNameBuilder = indexNameBuilder;
	}
	/**
	 * 查询模板
	 * @param template
	 * @return
	 * @throws ElasticSearchException
	 */
	public   String getTempate(String template) throws ElasticSearchException {
		return null;
	}
	
	/**
	 * 查询所有模板
	 * @return
	 * @throws ElasticSearchException
	 */
	public   String getTempate() throws ElasticSearchException {
		return null;
	}

	@Override
	public String cleanAllXPackIndices() throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateByQuery(String path) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateByQuery(String path, String entity) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateByQuery(String path, String templateName, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateByQuery(String path, String templateName, Object params) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> List<T> mgetDocuments(String index, String indexType, Class<T> type, Object... ids) throws ElasticSearchException {
		return null;
	}

	@Override
	public String mgetDocuments(String index, String indexType, Object... ids) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> List<T> mgetDocuments(String path, String entity, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> List<T> mgetDocuments(String path, String templateName, Object params, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> List<T> mgetDocuments(String path, String templateName, Map params, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public long count(String index, String entity) throws ElasticSearchException {
		return 0;
	}

	@Override
	public long count(String index, String template, Map params) throws ElasticSearchException {
		return 0;
	}

	@Override
	public long count(String index, String template, Object params) throws ElasticSearchException {
		return 0;
	}

	@Override
	public long countAll(String index) throws ElasticSearchException {
		return 0;
	}

	@Override
	public String updateDocument(String index, String indexType, Object id, Object params, Boolean detect_noop, Boolean doc_as_upsert) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocument(String index, String indexType, Object id, Map params, Boolean detect_noop, Boolean doc_as_upsert) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocument(String index, String indexType, Object id, Map params, String refreshOption, Boolean detect_noop, Boolean doc_as_upsert) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocument(String index, String indexType, Object id, Object params, String refreshOption, Boolean detect_noop, Boolean doc_as_upsert) throws ElasticSearchException {
		return null;
	}

	@Override
	public String reindex(String sourceIndice, String destIndice) {
		return null;
	}

	@Override
	public String reindex(String sourceIndice, String destIndice, String versionType) {
		return null;
	}

	@Override
	public String reindex(String sourceIndice, String destIndice, String opType, String conflicts) {
		return null;
	}

	@Override
	public String addAlias(String indice, String alias) {
		return null;
	}

	@Override
	public String removeAlias(String indice, String alias) {
		return null;
	}

	@Override
	public <T> List<T> sql(Class<T> beanType, String entity, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> List<T> sql(Class<T> beanType, String entity, Object bean) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> List<T> sql(Class<T> beanType, String entity) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T sqlObject(Class<T> beanType, String entity, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T sqlObject(Class<T> beanType, String entity, Object bean) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T sqlObject(Class<T> beanType, String entity) throws ElasticSearchException {
		return null;
	}

	public void addEvent(Event event,ElasticSearchEventSerializer  elasticSearchEventSerializer) throws ElasticSearchException {
		init();

	    
	    try {
			IndexRequestBuilder indexRequestBuilder = client.createIndexRequest(
			           indexNameBuilder , event,  elasticSearchEventSerializer);
//	    if (indexRequestBuilderFactory == null) {
//	      XContentBuilder bytesStream = null;
//	      try {
//	        bytesStream = client.getContentBuilder(event);
//	        indexRequestBuilder = client
//	                .prepareIndex(indexNameBuilder.getIndexName(event), indexType)
//	                .setSource(bytesStream );
//	      }
//	      finally {
//	        if(bytesStream != null){
////	          bytesStream.cl
//	        }
//	      }
//
//	    } else {
//	      indexRequestBuilder = client.createIndexRequest(
//	           indexNameBuilder.getIndexPrefix(event), indexType, event);
//	    }
//
//	    if (ttlMs > 0) {
//	      indexRequestBuilder.setTTL(ttlMs);
//	    }
			bulkRequestBuilder.add(indexRequestBuilder);
		} catch (IOException e) {
			throw new ElasticSearchException(e);
		}
	  }

 
	  public Object execute(String options) throws ElasticSearchException {
	    try {
	    	if(options != null) {
	    		if(options.indexOf("refresh=true") > 0) {
					bulkRequestBuilder.setRefreshPolicy("true");
				}
				else if(options.indexOf("refresh=wait_for") > 0){
					bulkRequestBuilder.setRefreshPolicy("wait_for");
				}
				else if(options.indexOf("refresh=false") > 0){
					bulkRequestBuilder.setRefreshPolicy("false");
				}
				else if(options.indexOf("refresh") > 0){
					bulkRequestBuilder.setRefreshPolicy("true");
				}
			}
	      BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
	      if (bulkResponse.hasFailures()) {
	        throw new EventDeliveryException(bulkResponse.buildFailureMessage());
	      }
	      return bulkResponse;
	    } finally {
	      
	    }
	  }
	  private void init(){
		  if (bulkRequestBuilder == null) {
		      bulkRequestBuilder = client.prepareBulk();
		    }
	  }


	@Override
	public String getDynamicIndexName(String indexName) {
		return this.indexNameBuilder.getIndexName(indexName);
	}

	@Override
	public CompleteRestResponse complateSuggest(String path, String entity) throws ElasticSearchException {
		return null;
	}

	@Override
	public CompleteRestResponse complateSuggest(String path, String templateName, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public CompleteRestResponse complateSuggest(String path, String templateName, Object params) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocumentWithParentId(String indexName, String indexType, Object bean, Object parentId) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocumentWithParentId(String indexName, String indexType, Object bean, Object parentId, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocumentWithParentId(String indexName, String indexType, Object bean, Object parentId) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocumentWithParentId(String indexName, String indexType, Object bean, Object parentId, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateByPath(String path, String entity) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateByPath(String path, String templateName, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateByPath(String path, String templateName, Object params) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocument(String index, String type, Object id, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocument(String index, String type, Object id, Object params) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocument(String index, String type, Object id, Map params, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocument(String index, String type, Object id, Object params, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String deleteByPath(String path) throws ElasticSearchException {
		return null;
	}

	@Override
	public String deleteByQuery(String path, String entity) throws ElasticSearchException {
		return null;
	}

	@Override
	public String deleteByQuery(String path, String templateName, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public String deleteByQuery(String path, String templateName, Object params) throws ElasticSearchException {
		return null;
	}

	public String deleteDocuments(String indexName, String indexType, String... ids) throws ElasticSearchException {
		init();
		for(int i = 0; i < ids.length; i ++){
			try {
				bulkRequestBuilder.add(client.deleteIndex(  indexName,   indexType,   ids[i]));
			} catch (Exception e) {
				throw new ElasticSearchException(e);
			}
		}
		return null;
		
	}

 
	public void updateIndexs(Event event,ElasticSearchEventSerializer  elasticSearchEventSerializer)throws ElasticSearchException{
		try {
			UpdateRequestBuilder indexRequestBuilder = client.updateIndexRequest(
					 event,  elasticSearchEventSerializer);
//	    if (indexRequestBuilderFactory == null) {
//	      XContentBuilder bytesStream = null;
//	      try {
//	        bytesStream = client.getContentBuilder(event);
//	        indexRequestBuilder = client
//	                .prepareIndex(indexNameBuilder.getIndexName(event), indexType)
//	                .setSource(bytesStream );
//	      }
//	      finally {
//	        if(bytesStream != null){
////	          bytesStream.cl
//	        }
//	      }
//
//	    } else {
//	      indexRequestBuilder = client.createIndexRequest(
//	           indexNameBuilder.getIndexPrefix(event), indexType, event);
//	    }
//
//	    if (ttlMs > 0) {
//	      indexRequestBuilder.setTTL(ttlMs);
//	    }
			bulkRequestBuilder.add(indexRequestBuilder);
		} catch (IOException e) {
			throw new ElasticSearchException(e);
		}
	}
	 
	public Client getClient() {
		// TODO Auto-generated method stub
		return this.client.getClient();
	}
	@Override
	public <T> T getIndexMapping(String index, ResponseHandler<T> responseHandler) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T getIndexMapping(String index, boolean pretty, ResponseHandler<T> responseHandler)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existIndice(String indiceName) throws ElasticSearchException {
		return false;
	}

	@Override
	public boolean existIndiceType(String indiceName, String type) throws ElasticSearchException {
		return false;
	}

	@Override
	public List<IndexField> getIndexMappingFields(String index, String indexType) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocuments(String indexName, String indexType, String addTemplate, List<?> beans)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateDocuments(String indexName, String indexType, String updateTemplate, List<?> beans)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocument(String indexName, String indexType, String addTemplate, Object bean)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getDocument(String indexName, String indexType, String documentId) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getDocument(String indexName, String indexType, String documentId, Map<String, Object> options)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentByPath(String path) throws ElasticSearchException {
		return null;
	}

	@Override
	public String getDocumentSource(String path) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T getDocumentByPath(String path, Class<T> beanType) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T getDocumentSource(String path, Class<T> beanType) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T getDocument(String indexName, String indexType, String documentId, Class<T> beanType)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T getDocument(String indexName, String indexType, String documentId, Map<String, Object> options,
			Class<T> beanType) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MapSearchHit getDocumentHit(String indexName, String indexType, String documentId,
			Map<String, Object> options) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MapSearchHit getDocumentHit(String indexName, String indexType, String documentId)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDateDocument(String indexName, String indexType, String addTemplate, Object bean)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDateDocuments(String indexName, String indexType, String addTemplate, List<?> beans)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteDocument(String indexName, String indexType, String id) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object executeRequest(String path, String entity) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object executeRequest(String path) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String executeHttp(String path, String action) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T executeHttp(String path, String action, ResponseHandler<T> responseHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T discover(String path, String action, ResponseHandler<T> responseHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T executeHttp(String path, String entity, String action, ResponseHandler<T> responseHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public String executeHttp(String path, String entity, String action) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T executeHttp(String path, String entity, String action, Map params, ResponseHandler<T> responseHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public String executeHttp(String path, String entity, Map params, String action) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> T executeHttp(String path, String entity, String action, Object bean, ResponseHandler<T> responseHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public String executeHttp(String path, String entity, Object bean, String action) throws ElasticSearchException {
		return null;
	}

	@Override
	public String getIndexMapping(String index) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getIndexMapping(String index, boolean pretty) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String executeRequest(String path, String templateName, Map params) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String executeRequest(String path, String templateName, Object params) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T executeRequest(String path, String entity, ResponseHandler<T> responseHandler)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T executeRequest(String path, String templateName, Map params, ResponseHandler<T> responseHandler)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T executeRequest(String path, String templateName, Object params, ResponseHandler<T> responseHandler)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MapRestResponse search(String path, String templateName, Map params) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MapRestResponse search(String path, String templateName, Object params) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MapRestResponse search(String path, String entity) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TermRestResponse termSuggest(String path, String entity) throws ElasticSearchException {
		return null;
	}

	@Override
	public PhraseRestResponse phraseSuggest(String path, String entity) throws ElasticSearchException {
		return null;
	}

	@Override
	public TermRestResponse termSuggest(String path, String templateName, Object params) throws ElasticSearchException {
		return null;
	}

	@Override
	public PhraseRestResponse phraseSuggest(String path, String templateName, Object params) throws ElasticSearchException {
		return null;
	}

	@Override
	public TermRestResponse termSuggest(String path, String templateName, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public PhraseRestResponse phraseSuggest(String path, String templateName, Map params) throws ElasticSearchException {
		return null;
	}

	@Override
	public CompleteRestResponse complateSuggest(String path, String entity, Class<?> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public CompleteRestResponse complateSuggest(String path, String templateName, Object params, Class<?> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public CompleteRestResponse complateSuggest(String path, String templateName, Map params, Class<?> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public Map<String, Object> searchMap(String path, String templateName, Map params) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> searchMap(String path, String templateName, Object params)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> searchMap(String path, String entity) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getIndice(String index) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String dropIndice(String index) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateIndiceMapping(String action, String indexMapping) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createIndiceMapping(String indexName, String indexMapping) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateIndiceMapping(String action, String templateName, Object parameter)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createIndiceMapping(String indexName, String templateName, Object parameter)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateIndiceMapping(String action, String templateName, Map parameter) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createIndiceMapping(String indexName, String templateName, Map parameter)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ESIndice> getIndexes() throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String refreshIndexInterval(String indexName, int interval) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String refreshIndexInterval(String indexName, String indexType, int interval) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String refreshIndexInterval(int interval, boolean preserveExisting) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String refreshIndexInterval(int interval) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RestResponse search(String path, String templateName, Map params, Class<?> type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RestResponse search(String path, String templateName, Object params, Class<?> type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RestResponse search(String path, String entity, Class<?> type) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RestResponse search(String path, String templateName, Map params, ESTypeReferences type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RestResponse search(String path, String templateName, Object params, ESTypeReferences type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RestResponse search(String path, String entity, ESTypeReferences type) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> ESDatas<T> searchList(String path, String templateName, Map params, Class<T> type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ESDatas<T> searchAll(String index, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> searchScroll(String scroll, String scrollId, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scroll(String path, String dslTemplate, String scroll, Object params, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scroll(String path, String dslTemplate, String scroll, Map params, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scroll(String path, String dslTemplate, String scroll, Map params, Class<T> type, ScrollHandler<T> scrollHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scroll(String path, String dslTemplate, String scroll, Object params, Class<T> type, ScrollHandler<T> scrollHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scrollSlice(String path, String dslTemplate, Map params, String scroll, Class<T> type, ScrollHandler<T> scrollHandler, boolean parallel) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scrollSlice(String path, String dslTemplate, Map params, String scroll, Class<T> type, boolean parallel) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scroll(String path, String entity, String scroll, Class<T> type) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> scroll(String path, String entity, String scroll, Class<T> type, ScrollHandler<T> scrollHandler) throws ElasticSearchException {
		return null;
	}

	@Override
	public String searchScroll(String scroll, String scrollId) throws ElasticSearchException {
		return null;
	}

	@Override
	public String deleteScrolls(String... scrollIds) throws ElasticSearchException {
		return null;
	}

	@Override
	public String deleteAllScrolls() throws ElasticSearchException {
		return null;
	}

	@Override
	public String deleteScrolls(List<String> scrollIds) throws ElasticSearchException {
		return null;
	}

	@Override
	public <T> ESDatas<T> searchList(String path, String templateName, Object params, Class<T> type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> ESDatas<T> searchList(String path, String entity, Class<T> type) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T searchObject(String path, String templateName, Map params, Class<T> type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T searchObject(String path, String templateName, Object params, Class<T> type)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T> T searchObject(String path, String entity, Class<T> type) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T extends AggHit> ESAggDatas<T> searchAgg(String path, String entity, Map params, Class<T> type,
			String aggs, String stats, ESAggBucketHandle<T> aggBucketHandle) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T extends AggHit> ESAggDatas<T> searchAgg(String path, String entity, Object params, Class<T> type,
			String aggs, String stats, ESAggBucketHandle<T> aggBucketHandle) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T extends AggHit> ESAggDatas<T> searchAgg(String path, String entity, Class<T> type, String aggs,
			String stats, ESAggBucketHandle<T> aggBucketHandle) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T extends AggHit> ESAggDatas<T> searchAgg(String path, String entity, Map params, Class<T> type,
			String aggs, String stats) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T extends AggHit> ESAggDatas<T> searchAgg(String path, String entity, Object params, Class<T> type,
			String aggs, String stats) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <T extends AggHit> ESAggDatas<T> searchAgg(String path, String entity, Class<T> type, String aggs,
			String stats) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createTempate(String template, String entity) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createTempate(String template, String templateName, Object params) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String createTempate(String template, String templateName, Map params) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteTempate(String template) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteDocumentsWithrefreshOption(String indexName, String indexType, String refreshOption,
			String... ids) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocuments(String indexName, String indexType, String addTemplate, List<?> beans,
			String refreshOption) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String updateDocuments(String indexName, String indexType, String updateTemplate, List<?> beans,
			String refreshOption) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocument(String indexName, String indexType, String addTemplate, Object bean, String refreshOption)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDateDocument(String indexName, String indexType, String addTemplate, Object bean,
			String refreshOption) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDateDocuments(String indexName, String indexType, String addTemplate, List<?> beans,
			String refreshOption) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteDocument(String indexName, String indexType, String id, String refreshOption)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocuments(String indexName, String indexType, List<?> beans, String refreshOption)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocuments(String indexName, String indexType, List<?> beans) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDocuments(String indexName, String indexType, List<Map> beans, String docIdKey, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocumentsWithIdKey(String indexName, String indexType, List<Map> beans, String docIdKey) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocuments(String indexName, String indexType, List<Map> beans, String docIdKey, String parentIdKey, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocumentsWithIdKey(String indexName, String indexType, List<Map> beans, String docIdKey, String parentIdKey) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocuments(String indexName, String indexType, List<Map> beans, String docIdKey, String parentIdKey, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocumentsWithIdKey(String indexName, String indexType, List<Map> beans, String docIdKey, String parentIdKey) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocument(String indexName, String indexType, Object bean) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDocument(String indexName, String indexType, Object bean, String refreshOption)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDocumentWithId(String indexName, String indexType, Object bean, Object docId) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocumentWithId(String indexName, String indexType, Object bean, Object docId, Object parentId) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocument(String indexName, String indexType, Object bean, Object docId, Object parentId, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDocument(String indexName, String indexType, Object bean, Object docId, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocuments(String indexName, String indexType, List<?> beans) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDocumentsWithIdKey(String indexName, String indexType, List<Map> beans, String docIdKey) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocumentsWithIdKey(String indexName, String indexType, List<Map> beans, String docIdKey, String parentIdKey) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocuments(String indexName, String indexType, List<?> beans, String refreshOption)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDocuments(String indexName, String indexType, List<Map> beans, String docIdKey, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String updateDocuments(String indexName, String indexType, List<Map> beans, String docIdKey, String parentIdKey, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocument(String indexName, String indexType, Object bean) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String addDateDocument(String indexName, String indexType, Object bean, String refreshOption)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDateDocumentWithId(String indexName, String indexType, Object bean, Object docId) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocumentWithId(String indexName, String indexType, Object bean, Object docId, Object parentId) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocument(String indexName, String indexType, Object bean, Object docId, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocument(String indexName, String indexType, Object bean, Object docId, Object parentId, String refreshOption) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocuments(String indexName, String indexType, List<?> beans) throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDateDocumentsWithIdKey(String indexName, String indexType, List<Map> beans, String docIdKey) throws ElasticSearchException {
		return null;
	}

	@Override
	public String addDateDocuments(String indexName, String indexType, List<?> beans, String refreshOption)
			throws ElasticSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDateDocuments(String indexName, String indexType, List<Map> beans, String docIdKey, String refreshOption) throws ElasticSearchException {
		return null;
	}


}
