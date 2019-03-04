// Result variable for storing loop results.
def result = ''
// Closure to fill result variable with value.
def createResult = { 
    if (!it) {  // A bit of Groovy truth: it == 0 is false
        result = '0'
    } else {
        result += it
    }
}

// Classic for loop.
for (i = 0; i < 5; i++) {
    createResult(i)
}
assert '01234' == result

// Using int.upto(max).
0.upto(4, createResult)
assert '01234' == result

// Using int.times.
5.times(createResult)
assert '01234' == result

// Using int.step(to, increment).
0.step 5, 1, createResult
assert '01234' == result

// Classic while loop.
def z = 0
while (z < 5) {
    createResult(z)
    z++
}
assert '01234' == result

def list = [0, 1, 2, 3, 4]

// Classic Java for-each loop.
for (int i : list) {
    createResult(i)
}
assert '01234' == result

// Groovy for-each loop.
for (i in list) {
    createResult(i)
}
assert '01234' == result

// Use each method to loop through list values.
list.each(createResult)
assert '01234' == result

// Ranges are lists as well.
(0..4).each(createResult)
assert '01234' == result

// eachWithIndex can be used with closure: first parameter is value, second is index.
result = ''
list.eachWithIndex { listValue, index -> result += "$index$listValue" }
assert '0011223344' == result
