/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        String [] splitedUrl = startUrl.split("/");
        String hostName = splitedUrl[2];
        
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);
        Set<String> set = new HashSet<>();
        set.add(startUrl);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i< size; i++) {
                String curUrl = queue.poll();
                List<String> nextUrls = htmlParser.getUrls(curUrl);
                for (String url : nextUrls) {
                    if (url.contains(hostName) && !set.contains(url)) {
                        // add it to the queue
                        queue.add(url);
                        set.add(url);
                        
                    }
                }
                
            }
            
            
        }
        return new ArrayList<String>(set);
    }
}