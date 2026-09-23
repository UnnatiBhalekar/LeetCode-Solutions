class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);

        List<Coupon> validCoupons = new ArrayList<>();
        for(int i = 0; i < code.length; i++){
            if(!isActive[i]){
                continue;
            }

             if(!map.containsKey(businessLine[i])){
                continue;
            }

            String currentCode = code[i];
            if(currentCode == null || currentCode.isEmpty() || !currentCode.matches("^[a-zA-Z0-9_]+$")){
                continue;
            }

            validCoupons.add(new Coupon(currentCode, businessLine[i], map.get(businessLine[i])));
        }
        validCoupons.sort((a,b) -> {
            if(!a.priority.equals(b.priority)){
                return Integer.compare(a.priority, b.priority);
            }
                return a.code.compareTo(b.code);
        });
        List<String> result = new ArrayList<>();
        for(Coupon coupon: validCoupons){
            result.add(coupon.code);
        }
        return result;
    }

    private static class Coupon{
        String code;
        String businessLine;
        Integer priority;

        Coupon(String code, String businessLine, Integer priority){
            this.code = code;
            this.businessLine = businessLine;
            this.priority = priority;
        }


    }
}