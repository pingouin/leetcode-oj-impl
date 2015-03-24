/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]} two integers in an array, ie: [index1, index2]
 */

/**
 * 和java解法一样
 * 数组排序时需要自定义一个函数作为排序依据
 */
 
function sortNum(a, b) {
    return a - b;
}

var twoSum = function(numbers, target) {
    var result = [];
    
    var map = {};
    
    for(i=0; i<numbers.length; i++) {
        if(map.hasOwnProperty(numbers[i].toString())) {
            result[0] = i + 1;
            result[1] = map[numbers[i].toString()] + 1;
            
            break;
        }
        else {
            var dValue = target - numbers[i];
            map[dValue.toString()] = i;
        }
    }
    
    return result.sort(sortNum);
};