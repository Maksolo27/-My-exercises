'use strict';

const email1 = 'maksum@gmail.com';
const email2 = 'maks@ukr.net';
const email3 = 'bam@mail.ru';

const findPost = email => {
    let res1 = 0;
    let res2 = 0;
    for (let i in email) {
        const val = email[i];
        if (val === '@') {
            res1 += i;
        }
    }
    for (let j in email) {
        const val = email[j];
        if (val === '.') {
            res2 += j;
        }
    }

    const newemail = email.slice(res1, res2);
    return newemail;
}
const findDomen = email => {
    let res1 = 0;
    for (let j in email) {
        const val = email[j];
        if (val === '.') {
            res1 += j;
        }
    }
    const newemail = email.slice(res1, email.length);
    return newemail;
}

console.log(findPost(email1));
console.log(findPost(email2));
console.log(findPost(email3));
console.log(findDomen(email1));
console.log(findDomen(email2));
console.log(findDomen(email3));