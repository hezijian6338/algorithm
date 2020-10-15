# -*- coding: UTF-8 -*-
class Chain(object):
    def __init__(self, path=''):
        print(path)
        self._path = path

    def __getattr__(self, path):
        return Chain('%s/%s' % (self._path, path))

    # __call__ = __getattr__

    def __call__(self, path):
        print('--%s' % (path))
        return Chain('%s/%s' % (self._path, path))

    def __str__(self):
        return self._path

    __repr__ = __str__


print(Chain().hezijian('ttt').user.info)

print(Chain().t('1'))
