class NT {
    fun isPrime(x: Long): Boolean {
        when {
            x <= 1 -> return false
            x == 2L || x == 3L -> return true
            x % 2 == 0L || x % 3 == 0L -> return false
        }
        // check numbers of form 6k +- 1
        var i: Long = 5
        while (i * i <= x) {
            when {
                x % i == 0L || x % (i + 2) == 0L -> return false
            }
            i++
        }
        return true
    }

    tailrec fun gcd(a: Long, b: Long): Long {
        if (b == 0L)
            return a
        return gcd(b, a % b)
    }
}